package com.example.filmlerapp.uix.view

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.uix.viewmodel.AnasayfaViewModel
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController,anasayfaViewModel: AnasayfaViewModel){
    val filmlerListesi = anasayfaViewModel.filmlerListesi.observeAsState(listOf())
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Filmler") })},
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            columns = GridCells.Fixed(count = 2)
        ) {
            items(
                count = filmlerListesi.value.count(),
                itemContent =  {
                    val film = filmlerListesi.value[it]
                    Card(modifier = Modifier.padding(all = 5.dp)) {
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val filmJson = Gson().toJson(film)
                                navController.navigate("detaySayfa/${filmJson}")
                            }) {
                            val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${film.resim}"
                            GlideImage(imageModel = url, modifier = Modifier.size(200.dp,300.dp))
                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                                ){
                                Text(text = "${film.fiyat} ₺", fontSize = 24.sp)
                                Button(onClick = {
                                    scope.launch {
                                        snackbarHostState.showSnackbar("${film.ad} sepete eklendi")
                                    }
                                }) { Text(text = "Sepet") }
                            }
                        }
                    }
                }
            )
        }
    }
}