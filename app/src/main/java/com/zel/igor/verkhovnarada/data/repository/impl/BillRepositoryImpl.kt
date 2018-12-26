package com.zel.igor.verkhovnarada.data.repository.impl

import com.zel.igor.verkhovnarada.data.api.BillAPI
import com.zel.igor.verkhovnarada.data.model.Bill
import com.zel.igor.verkhovnarada.data.repository.BillRepository
import io.reactivex.Observable
import javax.inject.Inject

class BillRepositoryImpl
@Inject constructor(private var api: BillAPI) : BillRepository {
    override fun getBill(number: String): Observable<Bill> {
        return api.fetchBill(number)
    }
}