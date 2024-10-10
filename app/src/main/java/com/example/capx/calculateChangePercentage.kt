package com.example.capx

import com.example.capx.model.TimeSeriesDaily

fun calculateChangePercentage(timeSeries: Map<String, TimeSeriesDaily>): Double {

    val entries = timeSeries.entries.toList()

    if (entries.size < 2) return 0.0

    val latestDay = entries[0].value

    val previousDay = entries[1].value

    val latestClose = latestDay.close.toDouble()
    val previousClose = previousDay.close.toDouble()

    return ((latestClose - previousClose) / previousClose) * 100
}
