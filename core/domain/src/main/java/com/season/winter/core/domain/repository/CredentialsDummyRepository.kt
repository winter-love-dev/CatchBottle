package com.season.winter.core.domain.repository

interface CredentialsDummyRepository {

    val isLogin: Boolean
    val userName: String?
    fun login(userName: String)
    fun logout()
}