package com.zel.igor.verkhovnarada.di

import com.zel.igor.verkhovnarada.App
import com.zel.igor.verkhovnarada.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
}