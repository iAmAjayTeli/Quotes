package com.example.quotes.screens

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotes.Quote
import com.example.quotes.R

@Composable
fun QuotesListScreen(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {

    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp, 24.dp)
                .fillMaxWidth(1f),
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            style = MaterialTheme.typography.headlineMedium
        )
        QuoteList(data =data, onClick )
    }
}