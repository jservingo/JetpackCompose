package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.UUID

data class Tarea(
    val id: String,
    val titulo: String,
    val descripcion: String,
    val completada: Boolean
)

fun listaInicialDeTareas(): List<Tarea> {
    return listOf(
        Tarea(UUID.randomUUID().toString(), "Comprar alimentos", "Comprar leche, pan y huevos", false),
        Tarea(UUID.randomUUID().toString(), "Hacer ejercicio", "Ir al gimnasio por 30 minutos", true),
        Tarea(UUID.randomUUID().toString(), "Llamar a mamá", "Llamar a mamá para saber cómo está", false),
        Tarea(UUID.randomUUID().toString(), "Estudiar Jetpack Compose", "Dedicar 1 hora a aprender Jetpack Compose", true),
        Tarea(UUID.randomUUID().toString(), "Limpiar la casa", "Limpiar la sala y la cocina", false)
    )
    // Esta lista es inmutable, lo que significa que no se puede modificar directamente.
    // Si queremos modificar esta lista (por ejemplo, agregar o eliminar tareas),
    // tendríamos que crear una nueva lista con los cambios deseados. Esto es
    // importante para mantener la inmutabilidad y evitar efectos secundarios no
    // deseados en la UI.
}

@Composable
fun ListaDeTareas() {

    var tareas by remember { mutableStateOf(listaInicialDeTareas()) }
    // tareas es una variable de estado que contiene la lista de tareas. Al usar
    // remember y mutableStateOf, estamos diciendo que esta variable es reactiva,
    // lo que significa que cualquier cambio en esta variable hará que la UI se
    // recompondrá automáticamente para reflejar esos cambios.  En este caso,
    // tareas es una lista inmutable, lo que significa que no se puede modificar
    // directamente. Si queremos modificar esta lista (por ejemplo, agregar o
    // eliminar tareas), tendríamos que crear una nueva lista con los cambios
    // deseados y asignarla a tareas. Esto es importante para mantener la
    // inmutabilidad y evitar efectos secundarios no deseados en la UI. Al
    // crear una nueva lista con los cambios deseados, estamos asegurando que
    // la UI se actualice correctamente y que los datos de la lista se mantengan
    // consistentes a lo largo del ciclo de vida de la actividad.

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = {
                // Para agregar una nueva tarea, creamos una nueva lista que incluye
                // la nueva tarea
                val id = UUID.randomUUID().toString()
                tareas = tareas + Tarea(
                    id = UUID.randomUUID().toString(),
                    titulo = "Nueva Tarea $id",
                    descripcion = "Descripción de la nueva tarea $id",
                    completada = false
                )
                // Creamos una nueva lista de tareas nueva con la nueva tarea agregada
            },
        ){
            Text(text = "Agregar Tarea")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(tareas, key={ it.id }) { tarea ->
                TareaItem(
                    tarea = tarea,
                    onDelete = {
                        // Para eliminar una tarea, creamos una nueva lista que excluye
                        // la tarea a eliminar
                        tareas = tareas.filter { it.id != tarea.id }
                        // Creamos una nueva lista de tareas nueva sin la tarea eliminada
                    },
                    onToggleComplete = {
                        // Para marcar una tarea como completada o no completada, creamos
                        // una nueva lista donde la tarea modificada se reemplaza por una
                        // nueva instancia con el estado de completada actualizado
                        tareas = tareas.map {
                            if (it.id == tarea.id) {
                                it.copy(completada = !it.completada)
                            } else {
                                it
                            }
                        }
                        // Creamos una nueva lista de tareas nueva con la tarea modificada
                    }
                )
            }
        }
    }
}

@Composable
fun TareaItem(
    tarea: Tarea,
    onDelete: () -> Unit,
    onToggleComplete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (tarea.completada) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceTint
        ),
        shape = RoundedCornerShape(12.dp),
        //elevation = CardDefaults.cardElevation(4.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = tarea.titulo, style = MaterialTheme.typography.titleMedium)
                Text(text = tarea.descripcion, style = MaterialTheme.typography.bodyMedium)
                Button(onClick = onToggleComplete) {
                    Text(text = if (tarea.completada) "Marcar como Incompleta" else "Marcar como Completada")
                }
            }
            Button(onClick = onDelete, modifier = Modifier.width(120.dp)) {
                Text(text = "Eliminar")
            }
        }
    }
}