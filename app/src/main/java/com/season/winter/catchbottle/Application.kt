package com.season.winter.catchbottle

import android.app.Application
import com.season.winter.firestore.FireStoreConnectTest

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        FireStoreConnectTest().test()
    }

}