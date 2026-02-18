package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CircularProgreeIndicatorExample() {
    // Son componentes de interfaz de usuario que se utilizan para mostrar
    // el progreso de una tarea o proceso en curso. Ambos indicadores de progreso
    // pueden ser indeterminados (cuando no se conoce el tiempo estimado para
    // completar la tarea) o determinados (cuando se conoce el tiempo estimado
    // y se puede mostrar el progreso actual).

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.padding(60.dp),
            strokeWidth = 6.dp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun LinearProgressIndicatorExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth().padding(60.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}