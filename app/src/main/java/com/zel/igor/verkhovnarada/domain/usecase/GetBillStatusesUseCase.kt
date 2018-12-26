package com.zel.igor.verkhovnarada.domain.usecase

import com.zel.igor.verkhovnarada.data.model.Bill
import io.reactivex.Observable


interface GetBillStatusesUseCase {
    fun getBillStatuses(date: String): Observable<List<Bill>>
}
