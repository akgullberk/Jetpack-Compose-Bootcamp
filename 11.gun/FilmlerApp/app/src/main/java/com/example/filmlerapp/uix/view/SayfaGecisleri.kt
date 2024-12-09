package com.example.filmlerapp.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.uix.viewmodel.AnasayfaViewModel
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(anasayfaViewModel: AnasayfaViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            Anasayfa(navController = navController,anasayfaViewModel)
        }

        composable(
            "detaySayfa/{film}",
            arguments = listOf(
                navArgument("film"){type = NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("film")
            val nesne = Gson().fromJson(json,Filmler::class.java)
            DetaySayfa(nesne)
        }
    }
}