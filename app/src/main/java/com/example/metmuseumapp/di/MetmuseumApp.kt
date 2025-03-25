package com.example.metmuseumapp.di

import android.app.Application

class MetmuseumApp: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
        applicationComponent.inject(this)
    }
}