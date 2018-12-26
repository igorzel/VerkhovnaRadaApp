package com.zel.igor.verkhovnarada.presentation.activity

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.zel.igor.verkhovnarada.data.model.Bill
import com.zel.igor.verkhovnarada.domain.usecase.GetBillStatusesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewModel
@Inject constructor(private var billStatusesUseCase: GetBillStatusesUseCase) : ViewModel() {
    private val billStatuses: MutableLiveData<List<Bill>> = MutableLiveData()

    fun billStatuses(): LiveData<List<Bill>> {
        return billStatuses
    }

    @SuppressLint("CheckResult")
    fun onViewAppeared() {
        billStatusesUseCase
            .getBillStatuses("2018-12-22")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                billStatuses.value = result
            }, { error ->
                error.printStackTrace()
            })
    }
}
