package com.swyp.pickple

import android.app.Application
import timber.log.Timber

class PickpleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}