package com.example.sync_compose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SyncApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}