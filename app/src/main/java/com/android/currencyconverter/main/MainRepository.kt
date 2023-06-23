package com.android.currencyconverter.main

import com.android.currencyconverter.data.models.CurrencyResponse
import com.android.currencyconverter.util.Resource

interface MainRepository {
    suspend fun getRates(base:String):Resource<CurrencyResponse>
}