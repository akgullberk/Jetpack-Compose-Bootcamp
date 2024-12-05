package com.example.kullanicietkilesimi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(){
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember {SnackbarHostState()}
    val acilisKontrol = remember { mutableStateOf(false) }
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Anasayfa")})},
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState){
                Snackbar(
                    containerColor = Color.White,
                    contentColor = Color.Blue,
                    actionColor = Color.Red,
                    snackbarData = it
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                scope.launch {
                    val sb = snackbarHostState.showSnackbar("Silmek ister misin",
                        actionLabel = "Evet")

                    if(sb == SnackbarResult.ActionPerformed){
                        snackbarHostState.showSnackbar(message = "Silindi")
                    }
                }
            }) {
                Text(text = "Snackbar")
            }

            Button(onClick = {
                acilisKontrol.value = true
            }) {
                Text(text = "Alert")
            }

            if(acilisKontrol.value){
                AlertDialog(
                    onDismissRequest = { acilisKontrol.value = false },
                    title = { Text(text = "Başlık")},
                    text = { Text(text = "Mesaj")},
                    confirmButton = {

                        OutlinedButton(onClick = {
                            acilisKontrol.value = false
                            scope.launch {
                                snackbarHostState.showSnackbar("tamam seçildi")
                            }
                        }) {
                            Text(text = "Tamam")
                        }

                        OutlinedButton(onClick = {
                            acilisKontrol.value = false
                            scope.launch {
                                snackbarHostState.showSnackbar("İptal seçildi")
                            }
                        }) {
                            Text(text = "İptal")
                        }
                    }

                )
            }
        }

    }
}