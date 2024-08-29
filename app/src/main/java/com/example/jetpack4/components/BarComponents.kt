package com.example.jetpack4.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(texto:String){
    Text(text = texto, fontSize = 25.sp, color = Color.White)
}


@Composable
fun ActionButton(){
    FloatingActionButton(onClick = {}, containerColor = Color.Red, contentColor = Color.White) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar.")
    }
}


@Composable
fun MainIconButton(icon:ImageVector,onclick :() ->Unit){
    IconButton(onClick = {onclick()}) {
        Icon(imageVector = icon, contentDescription = null,tint = Color.White)
    }
}