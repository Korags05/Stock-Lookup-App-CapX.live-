package com.example.capx.presentation

import android.annotation.SuppressLint
import android.graphics.Paint.Cap
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capx.R
import com.example.capx.model.Stock

@SuppressLint("DefaultLocale")
@Composable
fun StockDetails(stock: Stock) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stock.companyName,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "$${String.format("%.2f", stock.currentPrice)}",
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id = R.color.green),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(8.dp))
        val arrow = if (stock.changePercentage >= 0) "\uD83D\uDCC8" else "\uD83D\uDCC9"

        Row {
            Text(
                text = "${String.format("%.2f", stock.changePercentage)}% ",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.orange),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = arrow,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp
            )
        }
    }
}