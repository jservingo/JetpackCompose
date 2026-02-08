package com.krental.cursodejetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MiHorizontalDivider() {
    Column(
        modifier = Modifier
    .fillMaxSize()
    .padding(16.dp),
        verticalArrangement = Arrangement.Center, //Top Bottom SpaceBetween SpaceEvenly
        horizontalAlignment = Alignment.CenterHorizontally //Start End
    ) {
        Text(
            text = "Seccion 1",
            style = MaterialTheme.typography.bodyLarge
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 15.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Seccion 2",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
