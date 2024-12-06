package com.example.kisileruygulamasi.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.uix.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.uix.viewmodel.KisiDetayViewModel
import com.example.kisileruygulamasi.uix.viewmodel.KisiKayitViewModel
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(anasayfaViewModel: AnasayfaViewModel,
                   kisiKayitViewModel: KisiKayitViewModel,
                   kisiDetayViewModel: KisiDetayViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            Anasayfa(navController,anasayfaViewModel)
        }

        composable("kisiKayitSayfa"){
            KisiKayitSayfa(kisiKayitViewModel)
        }

        composable(
            "kisiDetaySayfa/{kisi}",
            arguments = listOf(
                navArgument("kisi"){ type = NavType.StringType}
            )
            ){
            val json = it.arguments?.getString("kisi")
            val nesne = Gson().fromJson(json,Kisiler::class.java)
            KisiDetaySayfa(nesne,kisiDetayViewModel)
        }
    }
}