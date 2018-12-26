package com.zel.igor.verkhovnarada.di

import com.zel.igor.verkhovnarada.di.module.*
import com.zel.igor.verkhovnarada.presentation.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        APIModule::class,
        NetworkModule::class]
)
interface ActivityComponent {
    fun inject(activity: MainActivity)
}