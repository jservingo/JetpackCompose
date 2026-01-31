package com.krental.cursodejetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComponentColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally, //Start End
        verticalArrangement = Arrangement.Center //Top Bottom SpaceBetween SpaceEvenly
    ) {
        MiOutlinedButton()
        MiTextButton()
        MiImage()
        MiIcon()
    }
}

@Composable
fun ComponentRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween, //Start End Center SpaceEvenly
        verticalAlignment = Alignment.CenterVertically //Top Bottom
    ) {
        MiOutlinedButton()
        MiImage()
        MiIcon()
    }
}

