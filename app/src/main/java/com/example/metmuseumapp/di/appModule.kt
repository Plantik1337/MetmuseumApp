package com.example.metmuseumapp.di

import com.example.metmuseumapp.data.ObjectRepository
import com.example.metmuseumapp.data.ObjectRepositoryImpl
import com.example.metmuseumapp.domain.ObjectInteractor
import com.example.metmuseumapp.domain.ObjectInteractorImpl
import com.example.metmuseumapp.presenter.ObjectViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    //data
    single<ObjectRepository> { ObjectRepositoryImpl() }

    //domain
    factory<ObjectInteractor> { ObjectInteractorImpl(get()) }

    //viewModels
    viewModel { ObjectViewModel(get()) }

}