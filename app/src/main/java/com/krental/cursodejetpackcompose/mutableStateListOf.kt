package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MutableStateListOfExample() {
    // Es una función que se utiliza para crear una lista mutable que es observable
    // por Compose. Cualquier cambio en la lista (como agregar o eliminar elementos)
    // hará que la UI se recompondrá automáticamente para reflejar esos cambios.

    // Esto es especialmente útil cuando trabajas con listas de elementos en la UI,
    // como en un LazyColumn, donde los datos pueden cambiar en tiempo real y quieres
    // que la UI se actualice sin problemas sin necesidad de notificar manualmente
    // los cambios.

    val itemsList = remember { mutableStateListOf("Elemento 1", "Elemento 2", "Elemento 3") }
    // En este ejemplo, itemsList es una lista mutable que se puede modificar
    // (agregar o eliminar elementos). Cada vez que se modifique itemsList, la UI que dependa
    // de esta lista se recompondrá automáticamente para reflejar los cambios.

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(onClick = { itemsList.add("Elemento ${itemsList.size+1 }") }) {
            Text(text = "Agregar Elemento")
        }
        // El botón "Agregar Elemento" agrega un nuevo elemento a la lista itemsList
        // cada vez que se hace clic. El nuevo elemento se nombra como "Elemento X",
        // donde X es el número de elementos actuales en la lista más uno
        // (para mantener un conteo secuencial). Al agregar un nuevo elemento
        // a itemsList, la UI se recompondrá automáticamente

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(itemsList) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        // El texto muestra el contenido del elemento actual de la
                        // lista itemsList.
                        IconButton(
                            onClick = { itemsList.remove(item) },
                            modifier = Modifier.padding(16.dp)
                            // El botón de eliminación elimina el elemento actual
                            // de la lista itemsList cuando se hace clic.
                            // Al eliminar un elemento, la UI se recompondrá automáticamente
                            // para reflejar el cambio, mostrando la lista actualizada sin
                            // el elemento eliminado.
                        ) {
                            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                        }
                    }
                }
            }
        }
    }
}
