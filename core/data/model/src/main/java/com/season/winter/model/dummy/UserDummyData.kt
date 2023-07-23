package com.season.winter.model.dummy

import com.season.winter.model.credentials.User
import com.season.winter.model.credentials.UserType

fun generateUserDummyData(
    name: String,
    type: UserType = UserType.General
): User {
    return User(
        name = name,
        type = type,
        googleId = "",
        kakaoId = "",
        naverId = "",
        facebookId = "",
        appleId = "",
        registerDateTome = "",
        lastConnectionDateTime = "",
    )
}