package com.example.jetpack4.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpack4.components.ActionButton
import com.example.jetpack4.components.MainButton
import com.example.jetpack4.components.Space
import com.example.jetpack4.components.TitleView
import com.example.jetpack4.navigation.DetailView2
import kotlinx.serialization.Serializable


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController){
    Scaffold (topBar = { CenterAlignedTopAppBar(title = { TitleView(texto = "Home view.")},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Red))},
        floatingActionButton = { ActionButton()}){
        ContentHomeView(navController)
    }
}


@Composable
fun ContentHomeView(navC:NavController){
    val id = 123
    var opcional by remember { mutableStateOf("")}
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        TitleView(texto = "Home View.")
        Space()
        TextField(value = opcional, onValueChange = {opcional = it},label = {
            Text(text = "Opcional")
        })
        if(opcional != ""){
            Text(text = opcional,fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }else{
            Space()
        }
        MainButton(texto = "DetailView", backColor = Color.Red, colorText = Color.White) {
            //navC.navigate("Detail/${id}/?${opcional}")
            if(opcional != ""){
                navC.navigate(DetailView2(id,opcional))
            }else{
                navC.navigate(DetailView2(id,null))
            }
        }
    }
}