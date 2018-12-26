package com.zel.igor.verkhovnarada.data.repository

import com.zel.igor.verkhovnarada.data.model.BillStatus
import io.reactivex.Observable

interface BillStatusesRepository {
    fun getBillStatuses(date: String): Observable<List<BillStatus>>
}
