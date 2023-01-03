package com.demo

import android.app.Application
import com.demo.country.BuildConfig
import timber.log.Timber

class DemoApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}