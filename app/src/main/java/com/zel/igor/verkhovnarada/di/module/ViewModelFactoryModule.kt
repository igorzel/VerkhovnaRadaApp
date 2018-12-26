package com.zel.igor.verkhovnarada.di.module

import android.arch.lifecycle.ViewModelProvider
import com.zel.igor.verkhovnarada.di.android.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}