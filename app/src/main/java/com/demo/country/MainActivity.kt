package com.demo.country

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("[MainActivity] onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}