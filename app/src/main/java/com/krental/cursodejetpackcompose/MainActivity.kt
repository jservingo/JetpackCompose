package com.krental.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.krental.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                // --------------------
                //Card ElevatedCard
                //MyCard()
                MyElevatedCard()
                /* --------------------
                //Lazy: Column Row VerticalGrid HorizontalGrid
                MyLazyHorizontalGrid()
                //MyLazyVerticalGrid()
                //MyLazyRowImagesWeb()
                //MyLazyRowImages()
                //MyLazyRowText()
                //MyLazyColumn()
                */
                /* --------------------
                //Layouts: Column Row Box
                ComponentBox()
                //ComponentRow()
                //ComponentColumn()
                */
                /*
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center, //Top Bottom SpaceBetween SpaceEvenly
                    horizontalAlignment = Alignment.CenterHorizontally //Start End
                ) {
                    /* -----------------
                    //HorizontalDivider
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
                    //Buttons Image Icon Spacer
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
                    //MiText y MiTextoReitilizable
                    MiTexto()
                    */
                }
                */
            }
        }
    }
}
