package com.krental.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.krental.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                ComponentRow()
                //ComponentColumn()
                /*
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center, //Top Bottom SpaceBetween SpaceEvenly
                    horizontalAlignment = Alignment.CenterHorizontally //Start End
                ) {
                    /* -----------------
                    Image Icon Spacer Divider
                    Text(text="Seccion 1",
                        style = MaterialTheme.typography.bodyLarge)
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical=15.dp),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(text="Seccion 2",
                        style=MaterialTheme.typography.bodyLarge)
                     */
                    /* ----------------
                    Botones
                    MiButton()
                    Spacer(modifier = Modifier.height(30.dp))
                    MiOutlinedButton()
                    Spacer(modifier = Modifier.height(30.dp))
                    MiTextButton()
                    Spacer(modifier = Modifier.height(30.dp))
                    MiImage()
                    Spacer(modifier = Modifier.height(30.dp))
                    MiIcon()
                    */
                    /* -----------------
                    MiText y MiTextoReitilizable
                    MiTexto()
                    */
                }
                */
            }
        }
    }
}


