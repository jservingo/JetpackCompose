package com.krental.cursodejetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun RememberExample() {
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

    val count = remember { mutableStateOf(0) }

    //Button(onClick = { count.value++ }) {
    //    Text("Contador: ${count.value}")
    //}
}