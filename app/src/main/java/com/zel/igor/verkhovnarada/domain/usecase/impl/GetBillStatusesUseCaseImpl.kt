package com.zel.igor.verkhovnarada.domain.usecase.impl

import com.zel.igor.verkhovnarada.data.model.Bill
import com.zel.igor.verkhovnarada.data.repository.BillRepository
import com.zel.igor.verkhovnarada.data.repository.BillStatusesRepository
import com.zel.igor.verkhovnarada.domain.usecase.GetBillStatusesUseCase
import io.reactivex.Observable
import javax.inject.Inject


class GetBillStatusesUseCaseImpl
@Inject constructor(
    private var billStatusesRepository: BillStatusesRepository,
    private var billRepository: BillRepository
) : GetBillStatusesUseCase {

    override fun getBillStatuses(date: String): Observable<List<Bill>> {
        val list: MutableList<Bill> = mutableListOf()
        val res = Observable.create<List<Bill>> { emitter ->
            billStatusesRepository
                .getBillStatuses(date)
                .concatMapIterable { billStatuses -> billStatuses }
                .concatMap { billStatus -> billRepository.getBill(billStatus.id) }
                .subscribe { bill ->
                    list.add(bill)
                    emitter.onNext(list)
                }
        }
        return res

//            .doOnNext { it -> }
//            .toList()
//            .toObservable()
//            .map { it -> listOf(it) }


//        return billStatusesRepository
//            .getBillStatuses(date)
//            .concatMapIterable { billStatuses -> billStatuses }
//            .concatMap { billStatus -> billRepository.getBill(billStatus.id) }
//            .toList()
//            .toObservable()
    }
}