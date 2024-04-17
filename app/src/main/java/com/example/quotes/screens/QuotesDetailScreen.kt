package com.example.quotes.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.quotes.DataManager
import com.example.quotes.Quote
import com.example.quotes.R

@Composable
fun QuotesDetails(quote: Quote) {

    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3E3)
                    )
                )
            )
    )
    {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            SelectionContainer {


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(16.dp, 24.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        imageVector = Icons.Filled.FormatQuote,
                        contentDescription = " ",
                        modifier = Modifier
                            .size(80.dp)
                            .rotate(180f)
                    )


                    Text(
                        text = quote.quote,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular))
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = quote.author,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }

    }
}

