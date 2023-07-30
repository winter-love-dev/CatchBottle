package com.season.winter.user.local.dummy

import com.season.winter.user.User
import com.season.winter.user.UserType


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