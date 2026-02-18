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
                //Componentes interactivos
                CanvasExample()
                //LinearProgressIndicatorExample()
                //SwitchExample()
                //RadioButtonExample()
                //PreferencesExample()
                //CheckBoxExample()
                //OutlinedTextFieldExample()
                //TextFieldExample()
                // --------------------
                //Administracion de estados
                //MutableStateListOfExample()
                //DerivedStateOfExample()
                //DerivedStateOf()
                //SwitchStateHoisting()
                //StateHoisting()
                //RememberSaveableExample()
                //RememberExample()
                // --------------------
                //Card ElevatedCard
                //MyElevatedCard()
                //MyCard()
                // --------------------
                //Lazy: Column Row VerticalGrid HorizontalGrid
                //MyLazyHorizontalGrid()
                //MyLazyVerticalGrid()
                //MyLazyRowImagesWeb()
                //MyLazyRowImages()
                //MyLazyRowText()
                //MyLazyColumn()
                // --------------------
                //Layouts: Column Row Box
                //ComponentBox()
                //ComponentRow()
                //ComponentColumn()
                // --------------------
                //HorizontalDivider
                //MiHorizontalDivider()
                // ----------------
                //Buttons Image Icon Spacer
                //MisBotones()
                // ----------------
                //MiTexto MiTextoReutilizable
                //MiTexto()
            }
        }
    }
}
