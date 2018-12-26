package com.zel.igor.verkhovnarada.di

import com.zel.igor.verkhovnarada.di.module.ActivityModule
import com.zel.igor.verkhovnarada.di.module.ViewModelFactoryModule
import com.zel.igor.verkhovnarada.di.module.ViewModelModule
import com.zel.igor.verkhovnarada.presentation.activity.MainActivity
import dagger.Component

//@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
@Component(modules = [ViewModelFactoryModule::class, ViewModelModule::class, ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}