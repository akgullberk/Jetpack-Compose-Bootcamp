package com.example.glidekullanimi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(){
    val resimAdi = remember { mutableStateOf("kofte.png") }
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Glide Kullanımı") })}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            val url = "http://kasimadalan.pe.hu/yemekler/resimler/${resimAdi.value}"
            GlideImage(imageModel = url, modifier = Modifier.size(200.dp,200.dp))

            Button(onClick = {
                resimAdi.value = "ayran.png"
            }) { Text(text = "Resim 1") }

            Button(onClick = {
                resimAdi.value = "su.png"
            }) { Text(text = "Resim 2") }
        }
    }
}