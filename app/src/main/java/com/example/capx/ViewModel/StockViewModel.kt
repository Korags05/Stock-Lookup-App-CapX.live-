package com.example.capx.ViewModel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.capx.Result
import com.example.capx.calculateChangePercentage
import com.example.capx.model.Stock
import com.example.capx.repo.StockRepo


class StockViewModel : ViewModel() {
    private val repository = StockRepo()

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getStockData(symbol: String, callback: (Result<Stock>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = repository.fetchStockData(symbol)

                if (response != null) {
                    val timeSeries = response.timeSeries
                    val latestEntry = timeSeries.entries.first()

                    val stock = Stock(
                        companyName = response.metaData.symbol.uppercase(),
                        currentPrice = latestEntry.value.close.toDouble(),
                        changePercentage = calculateChangePercentage(timeSeries)
                    )
                    callback(Result.Success(stock))
                } else {
                    callback(Result.Error("Invalid stock symbol or no data available"))
                }
            } catch (e: Exception) {
                callback(Result.Error(e.message ?: "Unknown error occurred"))
            }
        }
    }
}
