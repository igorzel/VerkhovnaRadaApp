package com.zel.igor.verkhovnarada

import android.app.Application
import com.zel.igor.verkhovnarada.di.AppComponent
import com.zel.igor.verkhovnarada.di.DaggerAppComponent
import com.zel.igor.verkhovnarada.di.module.AppModule

class App: Application() {
//    val component: AppComponent by lazy {
//        DaggerAppComponent
//            .builder()
//            .appModule(AppModule(this))
//            .build()
//    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.create().inject(this)
//        component.inject(this)
    }
}