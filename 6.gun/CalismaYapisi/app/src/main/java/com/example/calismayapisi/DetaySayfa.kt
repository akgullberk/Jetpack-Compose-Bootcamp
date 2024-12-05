package com.example.calismayapisi

import android.util.Log
import androidx.activity.compose.BackHandler
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetaySayfa(navController: NavController,gelenAd:String,gelenYas:Int,gelenBoy:Float,gelenBekar:Boolean,gelenUrun:Urunler){
    Scaffold(topBar = { TopAppBar(title = { Text(text = "Detay Sayfa") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("$gelenAd - $gelenYas - $gelenBoy - $gelenBekar - ${gelenUrun.id} - ${gelenUrun.ad}")

        }
    }

    BackHandler(false) {//true : geri dönüş aktif değil
        Log.e("Detay Sayfa","Geri tuşu basıldı")
    }
}