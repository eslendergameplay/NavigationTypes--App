package com.example.jetpack4.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpack4.components.MainButton
import com.example.jetpack4.components.MainIconButton
import com.example.jetpack4.components.Space
import com.example.jetpack4.components.TitleBar
import com.example.jetpack4.components.TitleView
import com.example.jetpack4.navigation.Home

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navC:NavController,id:Int,opcional:String?){
    Scaffold (topBar = {
        TopAppBar(title = { TitleBar(texto = "Detail view")}, colors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = Color.Blue
    ), navigationIcon = { MainIconButton(icon = Icons.Default.ArrowBack) {
            navC.navigate(Home)
        }
    })
    }){
        ContentDetailView(navC,id,opcional)
    }
}

@Composable
fun ContentDetailView(navController: NavController,id:Int,opcional: String?){
    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        TitleView(texto = "DetailView")
        Space()
        TitleView(texto = id.toString())
        if(!opcional.isNullOrEmpty()){
            TitleView(texto = opcional)
            /*Si es solo != ""
            TitleView(texto = opcional.orEmpty())

             */
        }else{
            Spacer(modifier = Modifier.height(0.dp))
        }
        MainButton(texto = "Return Home.", backColor = Color.Blue, colorText = Color.White ) {
            println("Vuelta Atras.")
            navController.popBackStack()
        }


    }
}