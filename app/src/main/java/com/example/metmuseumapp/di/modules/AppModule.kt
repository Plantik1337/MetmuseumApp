package com.example.metmuseumapp.di.modules

import android.app.Application
import android.content.Context
import com.example.metmuseumapp.data.ObjectRepository
import com.example.metmuseumapp.data.ObjectRepositoryImpl
import com.example.metmuseumapp.domain.ObjectInteractor
import com.example.metmuseumapp.domain.ObjectInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    fun provideObjectRepository(): ObjectRepository = ObjectRepositoryImpl()

    @Provides
    fun provideInteractor(repository: ObjectRepository): ObjectInteractor =
        ObjectInteractorImpl(repository)
}