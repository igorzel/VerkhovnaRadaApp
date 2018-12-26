package com.zel.igor.verkhovnarada.data.api.impl

import com.google.gson.annotations.SerializedName
import com.zel.igor.verkhovnarada.data.api.APIConfig
import com.zel.igor.verkhovnarada.data.api.BillAPI
import com.zel.igor.verkhovnarada.data.api.mapper.BillConsiderationStateMapper
import com.zel.igor.verkhovnarada.data.model.Bill
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

private data class BillResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("number") val number: String,
    @SerializedName("title") val title: String,
    @SerializedName("status") val status: String,
    @SerializedName("url") val url: String,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("filing_date") val fillingDate: String,
    @SerializedName("initiator_type") val initiatorType: String,
    @SerializedName("initiators") val initiators: List<Int>,
    @SerializedName("committee") val committee: Int,
    @SerializedName("committees") val committees: List<Int>
)

private interface BillApiService {

    @GET("legislation/2/bill/{number}/api/")
    fun fetchBill(@Path("number") number: String): Observable<BillResponse>

    companion object Factory {
        fun create(baseUrl: String): BillApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()

            return retrofit.create(BillApiService::class.java)
        }
    }
}

private class BillMapper {
    companion object {
        fun map(response: BillResponse): Bill {
            return Bill(
                number = response.number,
                title = response.title,
                status = BillConsiderationStateMapper.map(response.status),
                url = response.url
            )
        }
    }
}

class BillAPIImpl
@Inject constructor(private val apiConfig: APIConfig) : BillAPI {
    override fun fetchBill(number: String): Observable<Bill> {
        return BillApiService.create(apiConfig.baseUrl()).fetchBill(number).map { BillMapper.map(it) }
    }
}