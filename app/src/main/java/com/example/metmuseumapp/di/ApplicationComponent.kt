package com.example.metmuseumapp.di

import com.example.metmuseumapp.di.modules.AppModule
import com.example.metmuseumapp.di.modules.ViewModelModule
import com.example.metmuseumapp.presenter.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: MetmuseumApp)
    fun inject(activity: MainActivity)
}