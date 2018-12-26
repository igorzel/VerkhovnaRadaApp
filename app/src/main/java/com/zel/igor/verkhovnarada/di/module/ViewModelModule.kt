package com.zel.igor.verkhovnarada.di.module

import android.arch.lifecycle.ViewModel
import com.zel.igor.verkhovnarada.di.android.ViewModelKey
import com.zel.igor.verkhovnarada.presentation.activity.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}