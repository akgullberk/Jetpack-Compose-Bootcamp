package com.example.filmlerapp.uix.view

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmlerapp.data.entity.Filmler
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetaySayfa(gelenFilm:Filmler){
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = gelenFilm.ad) }) },
    ){ paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${gelenFilm.resim}"
            GlideImage(imageModel = url, modifier = Modifier.size(200.dp,300.dp))
            Text(text = "${gelenFilm.fiyat} ₺", fontSize = 50.sp)
        }
    }
}