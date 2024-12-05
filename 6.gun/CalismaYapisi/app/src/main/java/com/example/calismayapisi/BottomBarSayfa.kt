package com.example.calismayapisi

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarSayfa(){
    val secilenItem = remember { mutableStateOf(0) }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                content = {
                    NavigationBarItem(
                        selected = secilenItem.value == 0,
                        onClick = { secilenItem.value = 0 },
                        icon = {
                            Icon(painter = painterResource(id = R.drawable.anasayfa_resim),
                                contentDescription = "")
                        },
                        label = { Text(text = "Anasayfa")}
                    )

                    NavigationBarItem(
                        selected = secilenItem.value == 1,
                        onClick = { secilenItem.value = 1 },
                        icon = {
                            Icon(painter = painterResource(id = R.drawable.ayarlar_resim),
                                contentDescription = "")
                        },
                        label = { Text(text = "Ayarlar")}
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (secilenItem.value == 0) SayfaGecisleri(secilenSayfa = "anasayfa")
            if (secilenItem.value == 1) SayfaGecisleri(secilenSayfa = "ayarlarSayfa")
        }
    }
}