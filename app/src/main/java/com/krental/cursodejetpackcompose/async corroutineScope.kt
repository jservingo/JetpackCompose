package com.krental.cursodejetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun slowTask() {
    Log.d("Corrutinas","Iniciando tarea lenta")
    delay(3000)
    Log.d("Corrutinas","Tarea lenta finalizada")
}

@Composable
fun CorrutineScopeExample(){
    val corroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = {
                corroutineScope.launch {
                    //Este es el ámbito donde podemos ejecutar
                    //funciones suspendidas sin bloquear el
                    //hilo principal
                    slowTask()
                }
            }
        ){
            Text("Iniciar Tarea lenta")
        }
    }
}