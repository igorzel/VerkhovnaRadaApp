package com.zel.igor.verkhovnarada.data.repository.impl

import com.zel.igor.verkhovnarada.data.api.BillStatusesAPI
import com.zel.igor.verkhovnarada.data.model.BillStatus
import com.zel.igor.verkhovnarada.data.repository.BillStatusesRepository
import io.reactivex.Observable
import javax.inject.Inject

class BillStatusesRepositoryImpl
@Inject constructor(private var api: BillStatusesAPI) : BillStatusesRepository {
    override fun getBillStatuses(date: String): Observable<List<BillStatus>> {
        return api.fetchBillStatuses(date)
    }
}