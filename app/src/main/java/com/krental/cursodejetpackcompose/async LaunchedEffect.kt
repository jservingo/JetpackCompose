package com.krental.cursodejetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectExample() {
    //Si pasamos Unit, LaunchedEffect se ejecutara una sola vez
    //cuando se compone el Composable
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

@Composable
fun LaunchedEffectCounter() {
    var counter by remember { mutableIntStateOf(0) }

    LaunchedEffect(counter) {
        Log.d("LaunchedEffect","El contador cambio a: $counter")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text="Contador: $counter",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { counter++ }
        ){
            Text(text="Incrementar")
        }
    }
}