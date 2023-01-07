package com.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("[MainActivity] onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}