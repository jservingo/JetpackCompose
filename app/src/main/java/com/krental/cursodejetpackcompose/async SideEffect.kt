package com.krental.cursodejetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SideEffectExample() {
    var items by rememberSaveable {
        mutableStateOf(listOf("Item 1","Item 2", "Item 3"))
    }

    SideEffect {
        Log.d("SideEffect","La lista tiene ${items.size} elementos")

        //Podriamos enviarlos a Firebase o a un ViewModel. En este
        //ejemplo SideEfect de ejecuta solamente una sola vez ya
        //que la lista no va a cambiar. Pero si tuvieramos un boton
        //que al presionarlo agregara un nuevo elemento, se
        //volvería a realizar la recomposicion y se ejecutaría
        //nuevamente SideEffect.
    }
    //SideEffect se ejecuta en el hilo principal de manera asíncrona,
    //no admite corrutinas ni operaciones asíncronas

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Lista de elementos",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(items) {item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Text(
                        text = item,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

    }
}