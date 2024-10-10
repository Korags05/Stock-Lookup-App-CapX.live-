package com.example.stocklookupapp.ui

import android.graphics.drawable.Icon
import android.graphics.drawable.shapes.Shape
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.capx.R
import com.example.capx.ViewModel.StockViewModel
import com.example.capx.Result
import com.example.capx.model.Stock
import com.example.capx.presentation.StockDetails

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun StockApp(viewModel: StockViewModel) {
    var stockSymbol by remember { mutableStateOf("") }
    var stockData by remember { mutableStateOf<Stock?>(null) }
    var errorMessage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Image(
        painter = painterResource(id = R.drawable.capx_bg),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 258.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(

            value = stockSymbol,
            onValueChange = { stockSymbol = it },
            label = { Text("Enter stock symbol", fontFamily = FontFamily.SansSerif)},
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.baseline_attach_money_24), contentDescription = null)
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(id = R.color.white),
                focusedContainerColor = colorResource(id = R.color.white),
                focusedLabelColor = colorResource(id = R.color.gray),
                unfocusedLabelColor = colorResource(id = R.color.gray),
                focusedTextColor = colorResource(id = R.color.black),
                cursorColor = colorResource(id = R.color.orange)
            ),
            modifier = Modifier.clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.orange),
                contentColor = colorResource(
                    id = R.color.DarkOrange
                )
            ),
            onClick = {
                isLoading = true
                errorMessage = ""
                viewModel.getStockData(stockSymbol) { result ->
                    isLoading = false
                    when (result) {
                        is Result.Success -> stockData = result.data
                        is Result.Error -> errorMessage = result.message
                    }
                }
            }
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.padding(25.dp))

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (isLoading) {
                LinearProgressIndicator(color = colorResource(id = R.color.orange))
            } else if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            } else if (stockData != null) {
                StockDetails(stockData!!)
            }
        }


    }

}

