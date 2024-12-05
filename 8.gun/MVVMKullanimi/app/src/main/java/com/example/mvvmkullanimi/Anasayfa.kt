package com.example.mvvmkullanimi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(anasayfaViewModel: AnasayfaViewModel){
    val tfSayi1 = remember { mutableStateOf("") }
    val tfSayi2 = remember { mutableStateOf("") }
    val sonuc = anasayfaViewModel.sonuc.observeAsState("0")

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "MVVM Kullanımı") })}
    ) { paddingValues ->  
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(text = sonuc.value, fontSize = 50.sp)

            TextField(
                value = tfSayi1.value,
                onValueChange = {tfSayi1.value = it},
                label = { Text(text = "Sayı 1")})

            TextField(
                value = tfSayi2.value,
                onValueChange = {tfSayi2.value = it},
                label = { Text(text = "Sayı 2")})

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
                ){

                Button(onClick = {
                    anasayfaViewModel.topla(tfSayi1.value,tfSayi2.value)
                }) { Text(text = "TOPLAMA") }

                Button(onClick = {
                    anasayfaViewModel.carp(tfSayi1.value,tfSayi2.value)
                }) { Text(text = "ÇARPMA") }
            }

        }
    }
}