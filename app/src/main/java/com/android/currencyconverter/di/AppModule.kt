package com.android.currencyconverter.di

import com.android.currencyconverter.data.CurrencyApi
import com.android.currencyconverter.main.MainRepository
import com.android.currencyconverter.util.Const.Companion.BASE_URL
import com.android.currencyconverter.util.DefaultMainRepository
import com.android.currencyconverter.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCurrencyApi():CurrencyApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CurrencyApi::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api:CurrencyApi):MainRepository =DefaultMainRepository(api)

    @Singleton
    @Provides
    fun provideDispatcher():DispatcherProvider = object :DispatcherProvider{
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfiend: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }

}