package com.krental.cursodejetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// En la carpeta res/drawable colocamos las imágenes
@Composable
fun MiImage() {
    //Imagen redonda con borde
    Image (
        painter = painterResource(id = R.drawable.pokemon_pikachu),
        contentDescription = "Descripcion de la imagen",
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Green, CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MiIcon() {
    Icon(
        imageVector = Icons.Default.Home,
        contentDescription = "Descripcion del icono",
        modifier = Modifier.size(35.dp),
        tint = MaterialTheme.colorScheme.primary
    )
}