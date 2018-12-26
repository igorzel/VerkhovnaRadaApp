package com.zel.igor.verkhovnarada.di.module

import com.zel.igor.verkhovnarada.data.api.BillAPI
import com.zel.igor.verkhovnarada.data.api.BillStatusesAPI
import com.zel.igor.verkhovnarada.data.repository.BillRepository
import com.zel.igor.verkhovnarada.data.repository.BillStatusesRepository
import com.zel.igor.verkhovnarada.data.repository.impl.BillRepositoryImpl
import com.zel.igor.verkhovnarada.data.repository.impl.BillStatusesRepositoryImpl
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {

    @Provides
    fun providesBillStatusesRepository(api: BillStatusesAPI): BillStatusesRepository {
        return BillStatusesRepositoryImpl(api)
    }

    @Provides
    fun providesBillRepository(api: BillAPI): BillRepository {
        return BillRepositoryImpl(api)
    }

}