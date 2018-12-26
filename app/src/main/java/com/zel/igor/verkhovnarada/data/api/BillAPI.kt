package com.zel.igor.verkhovnarada.data.api

import com.zel.igor.verkhovnarada.data.model.Bill
import io.reactivex.Observable


interface BillAPI {
    fun fetchBill(number: String): Observable<Bill>
}