package com.example.myapplication

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("getProduct")
    fun getProduct(@Query("barcode") barcode: String): Deferred<Product>

}

object NetworkManager {

    val api = Retrofit.Builder()
        .baseUrl("https://api.formation-android.fr/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(API::class.java)

    suspend fun getProduct(barcode: String): Product {
        return api.getProduct(barcode).await()
    }

}