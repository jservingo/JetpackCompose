package com.krental.cursodejetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MiTexto() {
    /*
    Text(text = "Soy un texto",
        color = Color.Blue,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    */
    Text(text = "Soy un texto",
        style = MaterialTheme.typography.headlineMedium.copy(
            fontFamily = FontFamily.Serif,
            fontSize = 55.sp,
            fontWeight = FontWeight.Thin
        ),
        color = MaterialTheme.colorScheme.primary
    )

    MiTextoReutilizable(
        text = "Texto reutilizable",
        fontSize = 30.sp
    )

    MiTextoReutilizable(
        text = "Texto reutilizable 2",
        color = MaterialTheme.colorScheme.secondary,
        fontFamily = FontFamily.Monospace,
        fontSize = 25.sp
    )

    Text(
        text = "Texto con modificadores",
        fontSize = 25.sp,
        modifier = Modifier
            .clickable {}
            .background(Color.Green)
            .border(2.dp, Color.Black)
            .padding(16.dp)
    )
    /*
    Text(text = "Encabezado grande",
        style = MaterialTheme.typography.displayLarge,
        color = MaterialTheme.colorScheme.primary
    )
    Text(text = "Cuerpo del texto",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.primary
    )
    Text(text = "Etiqueta pequeña",
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.primary
    )
    */
}
