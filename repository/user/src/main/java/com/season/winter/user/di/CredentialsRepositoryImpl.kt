package com.season.winter.user.di

import com.season.winter.user.local.CBCredentialsDao
import javax.inject.Inject

class CredentialsRepositoryImpl @Inject constructor(
    private val credentials: CBCredentialsDao
): CredentialsService {

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