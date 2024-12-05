package com.example.calismayapisi

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController){
    val sayac = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true) {
        Log.e("Anasayfa","LaunchedEffect çalıştı")
        //Sayfa her göründüğünde çalışır.
        //Sayfaya geri dönüldüğünde çalışır.
    }

    DisposableEffect(Unit) {
        onDispose {
            Log.e("Anasayfa","DisposableEffect çalıştı")
            //Sayfa her görünmez olduğunda çalışır.
        }
    }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Anasayfa") }) }) { paddingValues ->
        Log.e("Anasayfa","Yenilendi")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sayaç : ${sayac.value}")
            Button(onClick = {
                sayac.value = sayac.value + 1
            }) { Text("Tıkla") }
            Button(onClick = {
                val urun = Urunler(100,"TV")
                val jsonUrun = Gson().toJson(urun)
                navController.navigate("detaySayfa/Ahmet/23/1.78f/true/$jsonUrun"){
                    popUpTo("anasayfa"){inclusive = true}
                }
            }) { Text("Detay") }
        }
    }
}