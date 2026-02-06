package com.krental.cursodejetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun MyLazyColumn() {
    val itemsList = List(100) { "Elemento No $it" }

    LazyColumn(
        modifier = Modifier
            .padding(32.dp)
    ) {
        //Crear un único elemento
        item {
            Text(
                text="Encabezado de la lista",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp
            )
        }

        items(itemsList) { item->
            Text(text=item, fontSize=20.sp)
            Text(text="Descripcion del item", fontSize=20.sp)
            Text(text="Precio", fontSize=20.sp)
            Spacer(modifier = Modifier.height(30.dp))
        }

        item {
            Text(
                text="Pie de la lista",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun MyLazyRowText() {
    val itemsLanguages = listOf("Kotlin","JavaScript","Java","Python","Swift","C#","PHP","C++","Swift")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemsLanguages) { item->
            Text(
                text=item,
                fontSize=20.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp),
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun MyLazyRowImages() {
    // Implementación similar a MyLazyRowText pero con imágenes
    val listOfImages = listOf(
        R.drawable.imagen1, R.drawable.imagen2, R.drawable.imagen3,
        R.drawable.imagen4, R.drawable.imagen5, R.drawable.imagen6,
        R.drawable.imagen7, R.drawable.imagen8, R.drawable.imagen9,
        R.drawable.imagen10, R.drawable.imagen11, R.drawable.imagen12,
        R.drawable.imagen13, R.drawable.imagen14, R.drawable.imagen15,
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listOfImages) { item->
            // Aquí iría el código para mostrar la imagen
            Image(
                painter = painterResource(id = item),
                contentDescription = "Imagen $item",
                modifier = Modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun MyLazyRowImagesWeb() {
    // Implementación similar a MyLazyRowText pero con imágenes desde la web
    val listOfImages = listOf(
        "https://picsum.photos/id/237/200/300",
        "https://picsum.photos/id/238/200/300",
        "https://picsum.photos/id/239/200/300",
        "https://picsum.photos/id/240/200/300",
        "https://picsum.photos/id/241/200/300",
        "https://picsum.photos/id/242/200/300",
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listOfImages) { item->
            // Aquí iría el código para mostrar la imagen desde la web
            // Usualmente se usaría una librería como Coil o Glide para cargar imágenes desde URLs
            AsyncImage(
                model = item,
                contentDescription = "Imagen desde la web",
                modifier = Modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}


