package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val mapSaver = listSaver<SnapshotStateMap<String,String>, Pair<String,String>>(
    save = { it.toList() },
        // Convierte el mapa mutable en una lista de pares clave-valor
        // (List<Pair<String, String>>) para guardarlo. Esto es necesario
        // porque los mapas no son directamente serializables,
        // pero las listas de pares sí lo son, lo que permite que el estado
        // del mapa se guarde correctamente durante cambios de configuración.
    restore = {
        val map = mutableStateMapOf<String, String>()
        it.forEach { pair ->
            val (key,value) = pair as Pair<String, String>
            map[key] = value
        }
        map
    }
        // Convierte la lista de pares clave-valor de vuelta a un mapa mutable
        // (Map<String, String>) al restaurar el estado. Esto asegura que el
        // mapa se restaure correctamente con sus datos intactos después de
        // cambios de configuración, como rotaciones de pantalla, manteniendo
        // así la integridad de los datos del mapa a lo largo del ciclo de
        // vida de la actividad.
)
// mapSaver es un saver personalizado que se utiliza para guardar y
// restaurar un mapa mutable de tipo Map<String, String>. El saver
// convierte el mapa en una lista de pares clave-valor (List<Pair
// <String, String>>) para guardarlo, y luego restaura el mapa a
// partir de esa lista cuando sea necesario. Esto es útil para
// mantener el estado del mapa a través de cambios de configuración,
// como rotaciones de pantalla, asegurando que los datos del mapa
// se mantengan intactos durante el ciclo de vida de la actividad.

@Composable
fun MutableStateMapOfExample() {
    // Es una función que se utiliza para crear un mapa mutable que
    // es una colección de pares clave-valor observable por Compose.
    // Cualquier cambio en el mapa (como agregar, eliminar o modificar
    // elementos) hará que la UI se recompondrá automáticamente para
    // reflejar esos cambios.

    // Esto es especialmente útil cuando trabajas con datos en forma
    // de clave-valor en la UI, como en un formulario o una lista de
    // configuraciones, donde los datos pueden cambiar en tiempo real
    // y quieres que la UI se actualice sin problemas sin necesidad
    // de notificar manualmente los cambios.

    //val users = remember { mutableStateMapOf<String, String>("user1" to "Alice", "user2" to "Bob") }
    val users = rememberSaveable(saver = mapSaver) {
        mutableStateMapOf<String, String>()
    }
    // En este ejemplo, users es un mapa mutable que se puede modificar
    // (agregar, eliminar o modificar elementos). Cada vez que se modifique
    // users, la UI que dependa de este mapa se recompondrá automáticamente

    var maxKey: String = ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = {
                maxKey = (users.keys.maxOrNull() ?: "user0")
                maxKey = "${maxKey.substring(4).toInt() + 1}"
                users["user$maxKey"] = "User $maxKey"
            }
        ){
            Text(text = "Agregar Usuario: $maxKey")
        }
        // El botón "Agregar Usuario" agrega un nuevo par clave-valor al
        // mapa users cada vez que se hace clic. La nueva clave se nombra
        // como "userX", donde X es el número de elementos actuales en el
        // mapa más uno (para mantener un conteo secuencial), y el valor se
        // nombra como "User X". Al agregar un nuevo par clave-valor a users,
        // la UI se recompondrá automáticamente para reflejar los cambios.

        Spacer(modifier = Modifier.padding(16.dp))

        LazyColumn {
            items(users.toList()) { (key, value) ->
                //Text(text = "$key: $value")
                UserItem(key = key, value = value, onDelete = { users.remove(key) })
            }
        }
    }
}


@Composable
fun UserItem(key: String, value: String, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 4.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(text = "Key: $key", style = MaterialTheme.typography.bodyLarge)
                Text(text = value, style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar Usuario"
                )
            }
            // El botón de eliminación elimina el par clave-valor actual del
            // mapa users cuando se hace clic. Al eliminar un par clave-valor,
            // la UI se recompondrá automáticamente para reflejar el cambio,
            // mostrando la lista actualizada sin el usuario eliminado.
        }
    }
}
