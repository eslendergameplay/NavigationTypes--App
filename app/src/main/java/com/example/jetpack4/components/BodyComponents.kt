package com.example.jetpack4.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleView(texto :String){
    Text(text = texto, fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MainButton(texto:String,backColor:Color,colorText:Color,onclick : ()->Unit){
    Button(onClick = {onclick()}, colors = ButtonDefaults.buttonColors(
        containerColor = backColor,
        contentColor = colorText
    )) {
        Text(text = texto)
    }
}