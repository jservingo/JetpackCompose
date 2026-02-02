package com.krental.cursodejetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

@Composable
fun ComponentBox() {
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Imagen de Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "Jetpack Compose",
            style = TextStyle(color = Color.Black, fontSize = 25.sp),
            //modifier = Modifier.align(Alignment.Center)
        )
        Button(
            {},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(50
                    .dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ){
            Text(text="Presione")
        }
    }
}
