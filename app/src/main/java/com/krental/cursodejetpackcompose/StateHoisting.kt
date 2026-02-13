package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Este es el composable padre que donde definimos el estado y la lógica de negocio,
// y pasamos el estado y los eventos al composable hijo a través de parámetros.
@Composable
fun StateHoisting() {
    // Un composable hijo no tiene estado propio, sino que recibe su estado
    // y eventos a través de parámetros. Esto permite que el estado sea
    // controlado por un componente padre, lo que facilita la reutilización
    // y la prueba de los componentes.

    // El composable hijo se vuelve más flexible y reutilizable, ya que
    // no está acoplado a un estado específico.

    // El composable padre expone un callback para manejar los eventos del hijo,
    // lo que permite una comunicación eficiente entre los componentes.

    var text by rememberSaveable { mutableStateOf("")}
    // Este es el estado que se va a compartir entre el composable padre y el hijo.
    // Usamos rememberSaveable para que el estado se mantenga a través de cambios
    // de configuración, como rotaciones de pantalla.

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyOwnTextField(
            text = text,
            onTextChange = { text = it }
        )
        // Pasamos el estado (text) y el evento (onValueChange) al
        // composable hijo (MyOwnTextField) a través de parámetros.
        // El composable hijo puede actualizar el estado del padre
        // a través del callback onValueChange, lo que permite una
        // comunicación eficiente entre los componentes.
    }
}

@Composable
fun MyOwnTextField(text: String, onTextChange: (String) -> Unit
) {
    // Este es el composable hijo que recibe el estado y los eventos a través de parámetros.
    // No tiene estado propio, lo que lo hace más flexible y reutilizable.

    // El composable hijo puede actualizar el estado del padre a través del callback
    // onValueChange, lo que permite una comunicación eficiente entre los componentes.

    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text("Escribe algo") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SwitchStateHoisting() {
    // Este es otro ejemplo de state hoisting, donde un composable hijo
    // recibe un estado booleano y un callback para cambiar ese estado.

    var isChecked by rememberSaveable { mutableStateOf(false) }
    // Estado booleano que se va a compartir entre el composable padre y el hijo.

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Modo oscuro: ${if (isChecked) "Activado" else "Desactivado"}")
        // Mostrar el estado actual del switch (activado o desactivado) en un texto

        Spacer(modifier = Modifier.height(16.dp))

        MyOwnSwitch(
            isChecked = isChecked,
            onCheckedChange = { isChecked = it },
        )
        // Pasamos el estado (isChecked) y el evento (onCheckedChange) al
        // composable hijo (MyOwnSwitch) a través de parámetros.
    }
}

@Composable
fun MyOwnSwitch(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    // Este es el composable hijo que recibe un estado booleano y un callback para cambiar ese estado.
    // No tiene estado propio, lo que lo hace más flexible y reutilizable.
    // El composable hijo puede actualizar el estado del padre a través del callback onCheckedChange,
    // lo que permite una comunicación eficiente entre los componentes.

    Switch(
        checked = isChecked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            uncheckedThumbColor = MaterialTheme.colorScheme.onSurfaceVariant,
            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
            uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant)
    )
}

