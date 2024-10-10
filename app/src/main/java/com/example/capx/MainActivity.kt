package com.example.capx

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresExtension
import com.example.capx.ViewModel.StockViewModel
import com.example.capx.ui.theme.CapXTheme
import com.example.stocklookupapp.ui.StockApp

class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {

        val viewModel: StockViewModel by viewModels()

        super.onCreate(savedInstanceState)
        setContent {
            CapXTheme {
                StockApp(viewModel)
            }
        }
    }
}
