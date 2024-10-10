package com.example.capx.repo

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.capx.API.RetrofitInstance
import com.example.capx.model.StockResponse

class StockRepo {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun fetchStockData(symbol: String): StockResponse? {
        return try {
            val response = RetrofitInstance.api.getStockData(symbol)

            if (response.timeSeries.isNullOrEmpty()) {
                throw Exception("Invalid stock symbol or no data available")
            }

            response
        } catch (e: HttpException) {
            throw Exception("Network error or invalid response")
        } catch (e: Exception) {
            throw Exception(e.message ?: "Unknown error occurred")
        }
    }
}
