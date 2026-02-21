package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


suspend fun obtenerDatosAPI(): String {
    delay(5000)
        //Suspende la ejecucion de la función sin bloquear el hilo
        // princial, permitiendo que otras tareas se ejecuten en
        // paralelo
    return ("JSG Techologies")
}

@Composable
fun LlamadaAPISimulada() {
    var usuario by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        usuario = obtenerDatosAPI()
        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
      if (isLoading) {
          CircularProgressIndicator()
      } else {
          usuario?.let {
              Text(
                  text = "Bienvenido: $it",
                  style = MaterialTheme.typography.headlineMedium
              )
          }
      }
    }
}