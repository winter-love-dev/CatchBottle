package com.season.winter.core.domain.repository

interface CredentialsRepository {

    val isLogin: Boolean
    val userName: String?
    fun login(userName: String)
    fun logout()
}