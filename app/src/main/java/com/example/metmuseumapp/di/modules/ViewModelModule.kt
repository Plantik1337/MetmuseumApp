package com.example.metmuseumapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.metmuseumapp.presenter.viewModel.ViewModelFactory
import com.example.metmuseumapp.presenter.viewModel.ViewModelKey
import com.example.metmuseumapp.presenter.viewModel.ObjectViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ObjectViewModel::class)
    abstract fun bindObjectViewModel(viewModel: ObjectViewModel): ViewModel
}