package com.zel.igor.verkhovnarada.di.module

import com.zel.igor.verkhovnarada.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp() = app
}