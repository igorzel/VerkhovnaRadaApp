package com.zel.igor.verkhovnarada.domain.usecase.impl

import com.zel.igor.verkhovnarada.data.model.Bill
import com.zel.igor.verkhovnarada.data.model.BillStatus
import com.zel.igor.verkhovnarada.data.repository.BillRepository
import com.zel.igor.verkhovnarada.data.repository.BillStatusesRepository
import com.zel.igor.verkhovnarada.domain.usecase.GetBillStatusesUseCase
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject


class GetBillStatusesUseCaseImpl
@Inject constructor(
    private var billStatusesRepository: BillStatusesRepository,
    private var billRepository: BillRepository
) : GetBillStatusesUseCase {

    override fun getBillStatuses(date: String): Observable<List<Bill>> {

        return billStatusesRepository
            .getBillStatuses(date)
            .concatMapIterable { billStatuses -> billStatuses }
            .concatMap { billStatus ->
                Observable.zip(
                    Observable.just(billStatus),
                    billRepository.getBill(billStatus.id),
                    BiFunction<BillStatus, Bill, Bill> { status, bill ->
                        mergeBillStatusAndBill(status, bill)
                    }
                )
            }
            .toList()
            .toObservable()
    }

    private fun mergeBillStatusAndBill(billStatus: BillStatus, bill: Bill): Bill {
        return Bill(bill.number, bill.title, billStatus.status, bill.url)
    }
}