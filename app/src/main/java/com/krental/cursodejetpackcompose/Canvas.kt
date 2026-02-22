package com.krental.cursodejetpackcompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CanvasExample() {
    // Es una herramienta poderosa que permite a los desarrolladores dibujar
    // gráficos personalizados utilizando un lienzo (canvas) en la interfaz
    // de usuario. Puedes crear formas, líneas, texto y otros elementos
    // gráficos de manera flexible y personalizada.

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val backgroundColor = MaterialTheme.colorScheme.primary
        Canvas(
            modifier = Modifier
                .size(300.dp)
                .padding(15.dp)) {
            drawCircle(
                color = backgroundColor,
                radius = size.minDimension/4,
                //center = Offset(100f, 100f)
            )
        }
    }
}