package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun TextFieldExample() {
    // Un TextField es un componente de entrada de texto que permite a los
    // usuarios ingresar y editar texto en una aplicación. Proporciona una caja de
    // texto donde los usuarios pueden escribir.

    // También puede incluir características adicionales, como un ícono de búsqueda,
    // un botón para borrar el texto, o incluso validación en tiempo real para
    // asegurarse de que el texto ingresado cumpla con ciertos criterios.

    // Puedes crear campos de entrada de texto interactivos personalizables en tu
    // aplicación. Puedes controlar el estado del TextField utilizando variables de
    // estado y manejar eventos como cambios en el texto o acciones del teclado.

    var text by remember { mutableStateOf("") }
    val isError = text.length > 10
    // Ejemplo de validación: el texto no debe exceder los 10 caracteres

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Nombre") },
            placeholder = { Text("Ingrese su nombre") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Ícono de persona"
                )
            },
            trailingIcon = {
                if (isError) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Ícono de error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            isError = isError,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { /* Manejar acción de "Done" del teclado */ }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        if (isError) {
            Text(
                text = "El nombre no debe exceder los 10 caracteres",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top= 5.dp)
            )
        }
    }
}