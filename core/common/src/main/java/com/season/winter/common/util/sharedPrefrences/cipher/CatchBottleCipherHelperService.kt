package com.season.winter.common.util.sharedPrefrences.cipher

interface CatchBottleCipherHelperService {

    fun encrypt(plainText: String): String
    fun decrypt(base64EncryptedCipherText: String): String
}