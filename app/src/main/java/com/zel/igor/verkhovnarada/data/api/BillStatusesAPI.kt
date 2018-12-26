package com.zel.igor.verkhovnarada.data.api

import com.zel.igor.verkhovnarada.data.model.BillStatus
import io.reactivex.Observable


interface BillStatusesAPI {
    fun fetchBillStatuses(date: String): Observable<List<BillStatus>>
}