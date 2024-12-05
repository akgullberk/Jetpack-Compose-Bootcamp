package com.example.widgetskullanimi

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(){
    val tf = remember { mutableStateOf("") }
    val alinanVeri = remember { mutableStateOf("") }
    val switchDurum = remember { mutableStateOf(false) }
    val checkboxDurum = remember { mutableStateOf(false) }
    val radioDeger = remember { mutableStateOf(0) }
    val progressDurum = remember { mutableStateOf(false) }
    val sliderDeger = remember { mutableStateOf(0f) }
    val ulkeListe = listOf("Türkiye","İtalya","Japonya")
    val acilisKontrol = remember { mutableStateOf(false) }
    val secilenIndeks = remember { mutableStateOf(0) }
    Scaffold(topBar = { TopAppBar(title = { Text(text = "Anasayfa") })}) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = alinanVeri.value)
            
            TextField(
                value = tf.value,
                onValueChange = {tf.value = it},
                label = { Text(text = "Veri giriniz") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(onClick = { alinanVeri.value = tf.value }) {
                Text(text = "Oku")
            }

            Image(painter = painterResource(id = R.drawable.resim), contentDescription = "")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Switch(checked = switchDurum.value, onCheckedChange = {switchDurum.value = it})
                    Text(text = "Android", modifier = Modifier.padding(10.dp))
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = checkboxDurum.value, onCheckedChange = {checkboxDurum.value = it})
                    Text(text = "Jetpack Compose", modifier = Modifier.padding(10.dp))
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = (1 == radioDeger.value), onClick = { radioDeger.value = 1 })
                    Text(text = "Barcelona", modifier = Modifier.padding(10.dp))
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = (2 == radioDeger.value), onClick = { radioDeger.value = 2 })
                    Text(text = "Real Madrid", modifier = Modifier.padding(10.dp))
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { progressDurum.value = true }) {
                    Text(text = "Başla")
                }

                if (progressDurum.value){
                    CircularProgressIndicator(color = Color.Gray)
                }

                Button(onClick = { progressDurum.value = false }) {
                    Text(text = "Dur")
                }
            }

            Text(text = "Sonuç : ${sliderDeger.value.toInt()}")

            Slider(
                value = sliderDeger.value,
                onValueChange = {sliderDeger.value = it},
                valueRange = 0f..100f,
                modifier = Modifier.padding(all = 10.dp))

            Box{
               Row(
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.Center,
                   modifier = Modifier
                       .size(100.dp, 50.dp)
                       .clickable {
                           acilisKontrol.value = true
                       },
               ) {
                   Text(text = ulkeListe[secilenIndeks.value])
                   Image(painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                       contentDescription = "")
               }

                DropdownMenu(
                    expanded = acilisKontrol.value,
                    onDismissRequest = { acilisKontrol.value = false }) {
                    ulkeListe.forEachIndexed { indeks, ulke ->
                        DropdownMenuItem(
                            text = { Text(ulke)},
                            onClick = {
                                secilenIndeks.value = indeks
                                acilisKontrol.value = false
                            }
                        )
                    }
                }
            }

            Box(modifier = Modifier.size(100.dp,50.dp).background(Color.Red)
                .pointerInput(Unit){ detectTapGestures (
                    onTap = {
                        Log.e("Sonuç","Tek Tıklandı")
                    },
                    onDoubleTap = {
                        Log.e("Sonuç","Çift Tıklandı")
                    },
                    onLongPress = {
                        Log.e("Sonuç","Uzun Basıldı")
                    }
                ) }
            )

            Button(onClick = {
                Log.e("Sonuç","Switch Durum   : ${switchDurum.value}")
                Log.e("Sonuç","Checkbox Durum : ${checkboxDurum.value}")
                Log.e("Sonuç","Radio Durum    : ${radioDeger.value}")
                Log.e("Sonuç","Slider Durum   : ${sliderDeger.value}")
                Log.e("Sonuç","Seçilen Ülke   : ${ulkeListe[secilenIndeks.value]}")
            }) { Text(text = "Göster") }
        }
    }
}