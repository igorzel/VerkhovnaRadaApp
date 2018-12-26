package com.zel.igor.verkhovnarada.di.module

import com.zel.igor.verkhovnarada.data.repository.BillRepository
import com.zel.igor.verkhovnarada.data.repository.BillStatusesRepository
import com.zel.igor.verkhovnarada.domain.usecase.GetBillStatusesUseCase
import com.zel.igor.verkhovnarada.domain.usecase.impl.GetBillStatusesUseCaseImpl
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun providesGetBillStatusesUseCase(
        billStatusesRepository: BillStatusesRepository,
        billRepository: BillRepository
    ): GetBillStatusesUseCase {
        return GetBillStatusesUseCaseImpl(billStatusesRepository, billRepository)
    }

}