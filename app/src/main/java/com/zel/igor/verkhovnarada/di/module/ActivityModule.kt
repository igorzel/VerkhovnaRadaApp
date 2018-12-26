package com.zel.igor.verkhovnarada.di.module

import com.zel.igor.verkhovnarada.data.api.APIConfig
import com.zel.igor.verkhovnarada.data.api.BillAPI
import com.zel.igor.verkhovnarada.data.api.BillStatusesAPI
import com.zel.igor.verkhovnarada.data.api.impl.APIConfigImpl
import com.zel.igor.verkhovnarada.data.api.impl.BillAPIImpl
import com.zel.igor.verkhovnarada.data.api.impl.BillStatusesAPIImpl
import com.zel.igor.verkhovnarada.data.repository.BillRepository
import com.zel.igor.verkhovnarada.data.repository.BillStatusesRepository
import com.zel.igor.verkhovnarada.data.repository.impl.BillRepositoryImpl
import com.zel.igor.verkhovnarada.data.repository.impl.BillStatusesRepositoryImpl
import com.zel.igor.verkhovnarada.domain.usecase.GetBillStatusesUseCase
import com.zel.igor.verkhovnarada.domain.usecase.impl.GetBillStatusesUseCaseImpl
import dagger.Module
import dagger.Provides


@Module
class ActivityModule {

    @Provides
    fun providesGetBillStatusesUseCase(
        billStatusesRepository: BillStatusesRepository,
        billRepository: BillRepository
    ): GetBillStatusesUseCase {
        return GetBillStatusesUseCaseImpl(billStatusesRepository, billRepository)
    }

    @Provides
    fun providesBillStatusesRepository(api: BillStatusesAPI): BillStatusesRepository {
        return BillStatusesRepositoryImpl(api)
    }

    @Provides
    fun providesBillRepository(api: BillAPI): BillRepository {
        return BillRepositoryImpl(api)
    }

    @Provides
    fun providesBillStatusesAPI(apiConfig: APIConfig): BillStatusesAPI {
        return BillStatusesAPIImpl(apiConfig)
    }

    @Provides
    fun providesBillAPI(apiConfig: APIConfig): BillAPI {
        return BillAPIImpl(apiConfig)
    }

    @Provides
    fun providesAPIConfig(): APIConfig {
        return APIConfigImpl()
    }
}