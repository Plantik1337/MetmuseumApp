package com.example.metmuseumapp.di

import com.example.metmuseumapp.data.ObjectRepository
import com.example.metmuseumapp.data.ObjectRepositoryImpl
import com.example.metmuseumapp.domain.ObjectInteractor
import com.example.metmuseumapp.domain.ObjectInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideObjectRepository(): ObjectRepository = ObjectRepositoryImpl()

    @Provides
    fun provideInteractor(repository: ObjectRepository): ObjectInteractor =
        ObjectInteractorImpl(repository)
}


//val appModule = module {
//    //data
//    single<ObjectRepository> { ObjectRepositoryImpl() }
//
//    //domain
//    factory<ObjectInteractor> { ObjectInteractorImpl(get()) }
//
//    //viewModels
//    viewModel { ObjectViewModel(get()) }
//
//}