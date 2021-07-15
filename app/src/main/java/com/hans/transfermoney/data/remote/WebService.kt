package com.hans.transfermoney.data.remote.expense

import com.google.gson.GsonBuilder
import com.hans.transfermoney.core.AppConstants
import com.hans.transfermoney.data.model.Expense
import com.hans.transfermoney.data.model.Transaction
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface WebService {
    @GET("expense")
    suspend fun expense(): List<Expense>

    @GET("transaction")
    suspend fun transaction(): List<Transaction>
}

object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }

}