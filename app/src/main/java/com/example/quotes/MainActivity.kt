package com.example.quotes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.quotes.screens.QuotesDetails
import com.example.quotes.screens.QuotesListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       CoroutineScope(Dispatchers.IO).launch {
           DataManager.loadAssetFromFile(applicationContext)
       }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val context= LocalContext.current.applicationContext
if(DataManager.isDataLoaded.value){
    if(DataManager.currentPage.value==Pages.LISTING){
        QuotesListScreen(data = DataManager.data) {
           DataManager.switchPages(it)
        }
    }
    else{
        QuotesDetails(quote = DataManager.currentQuote!!)
    }


}
    else{
    Toast.makeText(context, "Data is not loaded", Toast.LENGTH_SHORT).show()
    }
}


enum class Pages{
    LISTING,
    DETAILS
}
