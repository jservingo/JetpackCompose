package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun ProduceStateExample(){
    val datos = produceState(initialValue = "Cargando ...") {
        delay(3000)
        value = "Datos cargados correctamente"
        //Es util para lanzar una corrutina dentro de una funcion
        //que es composable y actualizar su estado de manera
        //segura sin necesidad de usar un LaunchedEffect que este
        //por separado
        //El nuevo valor de datos lo estamos obteniendo a partir
        //de produceState
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = datos.value
        )
    }
}

@Composable
fun FrasesRandom() {
    val frase by produceState<String?>(initialValue = null) {
        delay(2000)
        value = listOf(
            "El conocimiento es poder",
            "Nunca pares de aprender",
            "Jetpack Compose es el futuro de Android",
            "El conocimiento hace al maestro"
        ).random()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (frase==null) {
            CircularProgressIndicator()
        }else{
            Text(
                text= frase!!,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

    }
}


