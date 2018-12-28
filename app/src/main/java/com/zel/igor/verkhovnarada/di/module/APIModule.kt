package com.zel.igor.verkhovnarada.di.module

import com.zel.igor.verkhovnarada.data.api.APIConfig
import com.zel.igor.verkhovnarada.data.api.BillAPI
import com.zel.igor.verkhovnarada.data.api.BillStatusesAPI
import com.zel.igor.verkhovnarada.data.api.impl.APIConfigImpl
import com.zel.igor.verkhovnarada.data.api.impl.BillAPIImpl
import com.zel.igor.verkhovnarada.data.api.impl.BillStatusesAPIImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class APIModule {

    @Provides
    fun providesBillStatusesAPI(retrofit: Retrofit): BillStatusesAPI = BillStatusesAPIImpl(retrofit)

    @Provides
    fun providesBillAPI(retrofit: Retrofit): BillAPI = BillAPIImpl(retrofit)

    @Provides
    fun providesAPIConfig(): APIConfig = APIConfigImpl()
}