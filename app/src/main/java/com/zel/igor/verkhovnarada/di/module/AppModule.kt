package com.zel.igor.verkhovnarada.di.module

import com.zel.igor.verkhovnarada.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {

    @Provides
    fun provideApp() = app

}