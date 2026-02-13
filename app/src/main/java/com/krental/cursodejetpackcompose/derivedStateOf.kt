package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DerivedStateOf() {
    // derivedStateOf es una función que se utiliza para crear un estado derivado
    // a partir de otros estados. Es útil para optimizar el rendimiento al evitar
    // recomposiciones innecesarias cuando el estado derivado no cambia.

    // Se usa dentro de remember para crear un estado que se actualiza
    // automáticamente cuando los estados de los que depende cambian, pero
    // solo se recompondrá si el valor del estado derivado realmente cambia.

    // Esto es especialmente útil en casos donde el cálculo del estado derivado es
    // costoso o cuando quieres evitar recomposiciones innecesarias en la UI.

    var count by remember { mutableIntStateOf(0) }

    val espar by remember {
        derivedStateOf { count % 2 == 0 }
    }
    // En este ejemplo, espar es un estado derivado que se actualiza automáticamente
    // cada vez que count cambia, pero solo se recompondrá  si el valor de espar
    // realmente cambia, lo que optimiza el rendimiento al evitar recomposiciones
    // innecesarias cuando count cambia pero espar no cambia

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Contador: $count")
        Text(text = if (espar) "Es par" else "Es impar")
        Button(onClick = { count++ }) {
            Text(text = "Incrementar")
        }
    }
}

@Composable
fun DerivedStateOfExample() {
    // Aquí puedes usar derivedStateOf para crear un estado derivado
    // que dependa de otros estados y se actualice automáticamente
    // cuando esos estados cambien, pero solo se recompondrá si el
    // valor del estado derivado realmente cambia.

    var text by rememberSaveable { mutableStateOf("") }
    val textColor by remember {
        derivedStateOf {
            if (text.length > 5) Color.Red else Color.Blue
        }
    }
    // En este ejemplo, textColor es un estado derivado que se actualiza
    // automáticamente cada vez que text cambia, pero solo se recompondrá si el
    // valor de textColor realmente cambia, lo que optimiza el rendimiento al
    // evitar recomposiciones innecesarias cuando text cambia pero textColor
    // no cambia

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Escribe algo") },
            singleLine = true,
            //modifier = Modifier.fillMaxSize(),
            //textStyle = TextStyle(color = textColor)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Longitud ${text.length}",
            color = textColor,
            style = MaterialTheme.typography.headlineMedium
        )
        // Mostrar un mensaje que indique si el texto es largo o corto,
        // dependiendo de su longitud
    }
}