package com.example.jetpack4.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.jetpack4.views.DetailView
import com.example.jetpack4.views.HomeView

@Composable
fun NavManager(){
    val navc = rememberNavController()
    /*

    1er tipo de Navegacion
    NavHost(navController = navc, startDestination = "Home") {
        composable("Home"){
            HomeView(navc)
        }
        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id"){type = NavType.IntType},
            navArgument("opcional"){type = NavType.StringType}
        )){
            val id = it.arguments?.getInt("id")?:0
            var opcional = it.arguments?.getString("opcional")
            DetailView(navc,id,opcional)
        }
    }
    ?
     */

    //Segundo Tipo
    NavHost(navController = navc, startDestination = Home) {
        composable<Home>{
            HomeView(navc)
        }
        composable<DetailView2>{
            val detail = it.toRoute<DetailView2>()
            DetailView(navc,detail.id,detail.opcional)
        }
    }


}