package com.zel.igor.verkhovnarada.data.repository

import com.zel.igor.verkhovnarada.data.model.Bill
import io.reactivex.Observable

interface BillRepository {
    fun getBill(number: String): Observable<Bill>
}
