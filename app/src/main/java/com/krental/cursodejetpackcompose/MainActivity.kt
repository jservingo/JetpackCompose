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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
                //MiTexto()
                //MiButton()
                //MiOutlinedButton()
                MiTextButton()
            }
        }
    }
}

@Composable
fun MiButton() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Icon(Icons.Default.Person,contentDescription="Icono persona")
            Text(text="Presionar")
        }
    }
}

@Composable
fun MiOutlinedButton() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(2.dp,MaterialTheme.colorScheme.primary),
            modifier = Modifier.shadow(4.dp, shape=RoundedCornerShape(15.dp))
        ) {
            Icon(Icons.Default.Favorite,
                contentDescription =" Icono de favoritos",
                modifier = Modifier.size(25.dp)
            )
            Text(text="Favoritos")
        }
    }
}

@Composable
fun MiTextButton() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Este boton se utiliza para crear enlaces
        TextButton(
            onClick = { },
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text="Presione aquí")
        }
    }
}

@Composable
fun MiTexto() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*
        Text(text = "Soy un texto",
            color = Color.Blue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        */
        Text(text = "Soy un texto",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = FontFamily.Serif,
                fontSize = 55.sp,
                fontWeight = FontWeight.Thin
            ),
            color = MaterialTheme.colorScheme.primary
        )

        MiTextoReutilizable(
            text = "Texto reutilizable",
            fontSize = 30.sp
        )

        MiTextoReutilizable(
            text = "Texto reutilizable 2",
            color = MaterialTheme.colorScheme.secondary,
            fontFamily = FontFamily.Monospace,
            fontSize = 25.sp
        )

        Text(
            text = "Texto con modificadores",
            fontSize = 25.sp,
            modifier = Modifier
                .clickable {}
                .background(Color.Green)
                .border(2.dp, Color.Black)
                .padding(16.dp)
        )
        /*
        Text(text = "Encabezado grande",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(text = "Cuerpo del texto",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(text = "Etiqueta pequeña",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary
        )
        */
    }
}

