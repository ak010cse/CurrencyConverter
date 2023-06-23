package com.android.currencyconverter.data

import com.android.currencyconverter.data.models.CurrencyResponse
import com.android.currencyconverter.util.Const.Companion.ACCESS_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("/latest?access_key=$ACCESS_KEY")
    suspend fun getRates(
        @Query("base")base:String
    ):Response<CurrencyResponse>
}