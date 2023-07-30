package com.season.winter.user.di

interface CredentialsService {
    val isLogin: Boolean
    val userName: String?
    fun login(userName: String)
    fun logout()
}