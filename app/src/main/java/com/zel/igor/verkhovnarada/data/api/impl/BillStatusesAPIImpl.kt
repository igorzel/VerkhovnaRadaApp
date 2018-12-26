package com.zel.igor.verkhovnarada.data.api.impl

import com.google.gson.annotations.SerializedName
import com.zel.igor.verkhovnarada.data.api.APIConfig
import com.zel.igor.verkhovnarada.data.api.BillStatusesAPI
import com.zel.igor.verkhovnarada.data.api.mapper.BillConsiderationStateMapper
import com.zel.igor.verkhovnarada.data.model.BillStatus
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

private data class BillStatusResponse(
    @SerializedName("bill") val bill: String,
    @SerializedName("status") val status: String
)

private interface BillStatusesApiService {

    @GET("legislation/2/bill-statuses/{date}/api/")
    fun fetchBillStatuses(@Path("date") date: String): Observable<List<BillStatusResponse>>

    companion object Factory {
        fun create(baseUrl: String): BillStatusesApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()

            return retrofit.create(BillStatusesApiService::class.java)
        }
    }
}

private class BillStatusMapper {
    companion object {
        fun map(response: List<BillStatusResponse>): List<BillStatus> {
            return response.map {
                BillStatus(id = it.bill, status = BillConsiderationStateMapper.map(it.status))
            }
        }
    }
}

class BillStatusesAPIImpl
@Inject constructor(private val apiConfig: APIConfig) : BillStatusesAPI {
    override fun fetchBillStatuses(date: String): Observable<List<BillStatus>> {
        return BillStatusesApiService.create(apiConfig.baseUrl()).fetchBillStatuses(date)
            .map { BillStatusMapper.map(it) }
    }
}
