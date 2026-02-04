package com.krental.cursodejetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
fun MyLazyRow() {
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


