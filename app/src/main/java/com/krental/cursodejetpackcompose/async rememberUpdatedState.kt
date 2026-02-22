package com.krental.cursodejetpackcompose

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun RemembarUpdatedStateExample() {
    var message by remember { mutableStateOf("Hola desde Compose") }

    val context = LocalContext.current

    val currentMessage by rememberUpdatedState(message)
    //Este estado siempre se va a mantener actualizado sin reiniciar
    //el efecto secundario, como un LaunchedEffect. Siempre tendrá
    //el valor más reciente del estado message.

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = { message = "Mensaje actualizado" },
            modifier = Modifier.padding(16.dp)
            //Cuando el usuario presiona el boton, el mensaje message va
            //a cambiar y se mostrara en el Toast, aunque LaunchedEffect
            // este supendido por el delay
        ) {
            Text(text = "Mostrar mensaje actualizado")
        }

        LaunchedEffect(Unit) {
            delay(5000)
            //Si no hay terminado el delay y se hace click en el boton
            //se mostrara el mensaje actualizado
            Toast.makeText(context,currentMessage,Toast.LENGTH_SHORT).show()
        }
    }
}