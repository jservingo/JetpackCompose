package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxExample() {
    // Un CheckBox es un componente de interfaz de usuario que permite a los
    // usuarios seleccionar o deseleccionar una opción. Se representa como una
    // casilla cuadrada que puede estar marcada o desmarcada.

    // El estado del CheckBox se controla mediante variables de estado, lo que
    // permite a los desarrolladores manejar la lógica de selección y realizar
    // acciones en función de si el CheckBox está marcado o no.

    var acepted by remember { mutableStateOf(false) }

    Column (
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ){
             Checkbox(
                checked = acepted,
                onCheckedChange = { acepted = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary,
                    uncheckedColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    checkmarkColor = MaterialTheme.colorScheme.onPrimary
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if(acepted ) "Aceptado" else "Aceptar términos y condiciones")
        }
    }
}

@Composable
fun PreferencesExample() {
    // Un componente de preferencias es una interfaz de usuario que permite a los
    // usuarios configurar y personalizar su experiencia en una aplicación. Estos
    // componentes suelen incluir opciones como interruptores, casillas de verificación,
    // menús desplegables y campos de texto para que los usuarios puedan ajustar la
    // configuración según sus preferencias.

    val options = listOf(
        "Notificaciones",
        "Privacidad",
        "Idioma",
        "Tema",
        "Cuenta"
    )

    val stateOptions = remember {
        mutableStateMapOf<String, Boolean>().apply {
            options.forEach { put(it,false) }
        }
    }

    Column (
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Preferencias",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        LazyColumn {
            items(options.size) { index ->
                val option = options[index]
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ){
                    Checkbox(
                        checked = stateOptions[option] == true,
                        onCheckedChange = { stateOptions[option] = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = MaterialTheme.colorScheme.primary,
                            uncheckedColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            checkmarkColor = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = option)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val selected = stateOptions.filter { it.value }.keys.joinToString(", ")
        Text(
            text = "Seleccionado: ${if (selected.isEmpty()) "Ninguno" else selected}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

