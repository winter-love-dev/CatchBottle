package com.season.winter.core.data.repository

import com.season.winter.core.domain.repository.CredentialsDummyRepository
import com.season.winter.core.domain.repository.CredentialsRepository
import javax.inject.Inject

class CredentialsImpl @Inject constructor(
    private val credentials: CredentialsDummyRepository
): CredentialsRepository {

    override val isLogin: Boolean
        get() = credentials.isLogin

    override val userName: String?
        get() = credentials.userName

    override fun login(userName: String) {
        credentials.login(userName)
    }

    override fun logout() {
        credentials.logout()
    }

}