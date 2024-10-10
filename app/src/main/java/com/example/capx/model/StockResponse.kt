package com.example.capx.model

import com.google.gson.annotations.SerializedName

data class StockResponse(
    @SerializedName("Meta Data")
    val metaData: MetaData,

    @SerializedName("Time Series (Daily)")
    val timeSeries: Map<String, TimeSeriesDaily>
)