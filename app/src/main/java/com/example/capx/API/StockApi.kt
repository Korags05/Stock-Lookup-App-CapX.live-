package com.example.capx.API

import com.example.capx.model.StockResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StockAPI {
    @GET("query?function=TIME_SERIES_DAILY")
    suspend fun getStockData(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = "YOUR_API_KEY_HERE"
    ): StockResponse
}
