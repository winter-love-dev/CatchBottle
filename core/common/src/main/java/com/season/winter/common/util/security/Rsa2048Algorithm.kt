package com.season.winter.common.util.security

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import android.util.Log
import java.security.GeneralSecurityException
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.spec.RSAKeyGenParameterSpec
import javax.crypto.Cipher
import javax.inject.Inject

class Rsa2048Algorithm @Inject constructor(): RSA2048AlgorithmManager {

    private val rsaKeyAlgorithm = KeyProperties.KEY_ALGORITHM_RSA
    private val ecbBlock = KeyProperties.BLOCK_MODE_ECB
    private val pkcs1Padding = KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1

    val cipherAlgorithm = "$rsaKeyAlgorithm/$ecbBlock/$pkcs1Padding"

    // 보안 안정성을 위해 권장되는 key 길이 = 2048 bit 를 사용한다.
    private val keyLengthBit = 2048

    // 암호 유효 기간: 9년
    val validityYears = 9

    private val keyProviderName = "AndroidKeyStore"

    private lateinit var keyEntry: KeyStore.Entry

    override fun create(alias: String): Boolean {

        val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
        if (!keyStore.containsAlias(alias))
            return false

        keyEntry = keyStore.getEntry(alias, null)

        try {

            // RSA Android Key Store 생성
            with(
                KeyPairGenerator.getInstance(KeyProperties.KEY_ALGORITHM_RSA, keyProviderName)) {
                val spec = KeyGenParameterSpec.Builder(
                    alias,
                    KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
                )
                    .setAlgorithmParameterSpec(RSAKeyGenParameterSpec(keyLengthBit, RSAKeyGenParameterSpec.F4))
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                    .setDigests(
                        KeyProperties.DIGEST_SHA512,
                        KeyProperties.DIGEST_SHA384,
                        KeyProperties.DIGEST_SHA256
                    )

                    // true를 설정하면 사용자가 마지막 5분 이내에 인증한 경우에만 개인 키를 사용할 수 있습니다.
                    .setUserAuthenticationRequired(false)
                    .build()
                initialize(spec)
                generateKeyPair()
            }

            return true
        } catch (e: GeneralSecurityException) {
            Log.e(this.javaClass.simpleName, "create: e: ${e.message}",)
            return false
        }
    }

    //  암호화 길이 제한: 256바이트 이하 평문만 가능
    override fun encrypt(plainText: String): String {
        val cipher = Cipher.getInstance(cipherAlgorithm).apply {
            init(Cipher.ENCRYPT_MODE, (keyEntry as KeyStore.PrivateKeyEntry).certificate.publicKey)
        }
        val bytes = plainText.toByteArray(Charsets.UTF_8)
        val encryptedBytes = cipher.doFinal(bytes)
        val base64EncryptedBytes = Base64.encode(encryptedBytes, Base64.DEFAULT)

        return String(base64EncryptedBytes)
    }

    // 해독
    override fun decrypt(base64EncryptedCipherText: String): String {

        val cipher = Cipher.getInstance(cipherAlgorithm).apply {
            init(Cipher.DECRYPT_MODE, (keyEntry as KeyStore.PrivateKeyEntry).privateKey)
        }
        val base64EncryptedBytes = base64EncryptedCipherText.toByteArray(Charsets.UTF_8)
        val encryptedBytes = Base64.decode(base64EncryptedBytes, Base64.DEFAULT)
        val decryptedBytes = cipher.doFinal(encryptedBytes)

        return String(decryptedBytes)
    }
}