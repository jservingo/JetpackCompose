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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SnapshotFlowExample(){

    val textState = remember { mutableStateOf("") }
    val showAlert = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        snapshotFlow { textState.value }
            .collect{ text->
                showAlert.value = text.contains("Android", ignoreCase = true)
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { Text(text = "Escribe algo") },
            modifier = Modifier.fillMaxWidth()
        )

        if(showAlert.value) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Has escrito Android",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

