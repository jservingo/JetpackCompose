package com.krental.cursodejetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectExample() {
    //Si pasamos Unit, LaunchedEffect se ejecutara una sola vez
    // cuando se compone el Composable
    LaunchedEffect(Unit) {
        //CourrutineScope
        delay(2000)
        Log.d("LaunchedEffect","Se ejecuto despues de 2 seg")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text="Hola Jetpack Compose")
    }
}