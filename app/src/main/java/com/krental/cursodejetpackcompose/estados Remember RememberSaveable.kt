package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Aquí puedes usar remember para almacenar un valor
// que persista a través de recomposiciones

///Un composable se vuelve a ejecutar cada vez que
// cambia su estado o el estado de sus dependencias,
// actualizando solammente las partes que son necesarias
// sin reconstruir toda la jerarquía de UI,
// lo que mejora el rendimiento y la eficiencia.

// La recomposicion ocurre cuando un estado observable cambia,
// Jetpack Compose detecta ese cambio y vuelve a ejecutar
// el composable que depende de ese estado.
// Solo se recomponenen los composables afectados y no toda la UI.

//Si el framework detecta que la UI no cambiará, evita recomponerse.
//Si un remember o mutableStateOf no cambia, el composable no se recompondrá,
// lo que mejora el rendimiento al evitar actualizaciones innecesarias.

@Composable
fun RememberExample() {
    // Contar la cantidad de veces que se ha hecho clic en un botón
    // El contador se inicializa en 0 y se incrementa cada vez que se hace clic en el botón

    var count by remember { mutableIntStateOf(0) }
    //Crear el estado del contador utilizando remember y mutableIntStateOf
    // Esto asegura que el valor del contador se mantenga a través de recomposiciones
    // Al usar remember, el valor del contador se conserva incluso si el
    // composable se vuelve a ejecutar debido a cambios en otros estados o eventos.

    // Import androidx.compose.runtime.getValue y setValue
    // para usar la delegación de propiedades

    // La desventaja de usar remember es que el valor del contador se reiniciará a 0
    // si rotamos la pantalla o si el composable se destruye y se vuelve a crear,
    // ya que remember no persiste a través de cambios de configuración
    // o destrucción del composable.

    // Si queremos que el valor del contador persista a través de cambios de configuración,
    // devemos usar rememberSaveable en lugar de remember, lo que guardará el estado
    // incluso si el composable se destruye y se vuelve a crear.

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Contador: $count", style = MaterialTheme.typography.bodyLarge)
        // Mostrar el valor del contador en un botón
        // Cada vez que se hace clic en el botón, el contador se incrementa
        // y el texto del botón se actualiza para reflejar el nuevo valor

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count++ }) {
            // Al hacer clic en el botón, el contador se incrementa y
            // se muestra el valor actualizado en el texto del botón
            //debido a la reactividad de Compose

            Text("Incrementar")
        }
    }
}

@Composable fun RememberSaveableExample() {
    // Aquí puedes usar rememberSaveable para almacenar un valor
    // que persista a través de recomposiciones y también a través
    // de cambios de configuración como rotaciones de pantalla.

    var myName by rememberSaveable { mutableStateOf("") }
    // Crear el estado del nombre utilizando rememberSaveable y
    // mutableStateOf.

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ingrese su nombre", style = MaterialTheme.typography.titleMedium)
        // Mostrar un campo de texto para ingresar el nombre
        // Al usar rememberSaveable, el valor del campo de texto se conservará incluso
        // si el composable se destruye y se vuelve a crear, lo que permite que
        // el usuario mantenga su entrada a través de cambios de configuración
        // como la rotación de pantalla.

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = myName,
            onValueChange = { myName = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        // El valor ingresado se almacena en el estado myName
        // y se mantiene a través de recomposiciones y cambios de configuración
        // gracias a rememberSaveable.

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { myName="" }) {
            Text("Borrar nombre")
        }
    }
}
