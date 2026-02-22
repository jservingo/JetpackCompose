package com.krental.cursodejetpackcompose

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun DisposableEffectExample() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        DisposableEffect(Unit) {
            //Este se va a ejecutar cuando se componga el composable
            Log.d("DisposableEffect","El composable se ha compuesto")
            onDispose {
                //Se ejecuta cuando el composable se elimina de la composicion,
                //por ejemplo pasamos a otra pantalla o cerramos la app
                //Esto permitira limpiar el efecto secundario y evitar fugas
                //de memoria

                Log.d("DisposableEffect","El composable ha salido de composicion")
                
                //Por que es importante limpiar los efectos en DisposableEffect?
                //Estos pueden seguir activos, lo que puede causar varios problemas
                //(fugas de memoria o memory leaks).
                //Si registramos un listener u obserber y nunca lo removemos,
                //permanecera en memoria.
                //Podriamos seguir recibiendo eventos o datos de pantallas que
                //ya no estan visibles.
                //Mal rendimiento y crashes por referencias invalidas

            }
        }
        Text(
            text = "Este es un ejemplo con DisposableEffect",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )
        Button(
            onClick={
                (context as? Activity)?.finish()
            }
        ){
            Text(text="Cerrar App")
        }
    }
}