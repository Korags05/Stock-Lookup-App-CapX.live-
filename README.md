## Stock Lookup App
# Overview:
With the help of this Android app, users may look up stocks by symbol and view details like the company name, current price, and percentage change. 
Kotlin, Jetpack Compose, and Retrofit are used in the app's development in order to integrate the Alpha Vantage stock market API.

# Features:
1) Input a stock symbol (e.g., AAPL, TSLA) to search for stock data.
2) Displays the company name, current stock price, and percentage change.
3) Real-time stock data fetching with loading and error handling states.
4) Simple, clean user interface with user-friendly interaction.

# API Used:
The app uses the Alpha Vantage stock market API to fetch stock data.
1) Base URL: https://www.alphavantage.co/
2) API Endpoint: TIME_SERIES_DAILY
3) API Key: Use your own API key from Alpha Vantage.

# Tech Stack:
Kotlin: Programming language used for development.
Jetpack Compose: For building the user interface.
Retrofit: For API requests.
ViewModel: To manage UI-related data and lifecycle awareness.

# How to Set Up and Run the App
*Prerequisites:*
1) Android Studio (version 4.2 or above).
2) API Key from Alpha Vantage.

# Steps
1) Clone this repository:
2) Open the project in Android Studio.
3) Get your API key from Alpha Vantage.
4) In StockAPI.kt, replace the API key in the apikey field
   @Query("apikey") apiKey: String = "YOUR_API_KEY"
5) Run the app on an emulator or physical device.

