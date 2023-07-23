package com.season.winter.model.credentials

data class User(
    val name: String,
    val type: UserType,
    val googleId: String,
    val kakaoId: String,
    val naverId: String,
    val facebookId: String,
    val appleId: String,
    val registerDateTome: String,
    val lastConnectionDateTime: String
)