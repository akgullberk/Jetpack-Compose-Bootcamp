package com.example.calismayapisi

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(secilenSayfa:String){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = secilenSayfa) {
        composable("anasayfa"){
            Anasayfa(navController = navController)
        }

        composable("ayarlarSayfa"){
            AyarlarSayfa(navController = navController)
        }

        composable(
            "detaySayfa/{ad}/{yas}/{boy}/{bekar}/{urun}",
            arguments = listOf(
                navArgument("ad"){type = NavType.StringType},
                navArgument("yas"){type = NavType.IntType},
                navArgument("boy"){type = NavType.FloatType},
                navArgument("bekar"){type = NavType.BoolType},
                navArgument("urun"){type = NavType.StringType},
            )
        ){
            val ad = it.arguments?.getString("ad")!!
            val yas = it.arguments?.getInt("yas")!!
            val boy = it.arguments?.getFloat("boy")!!
            val bekar = it.arguments?.getBoolean("bekar")!!

            val jsonUrun = it.arguments?.getString("urun")!!
            val urun = Gson().fromJson(jsonUrun,Urunler::class.java)
            DetaySayfa(navController = navController,ad,yas,boy,bekar,urun)
        }
    }
}