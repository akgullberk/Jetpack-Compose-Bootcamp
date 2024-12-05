package com.example.tasarimcalismasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasarimcalismasi.ui.theme.AnaRenk
import com.example.tasarimcalismasi.ui.theme.AnaRenkDark
import com.example.tasarimcalismasi.ui.theme.TasarimCalismasiTheme
import com.example.tasarimcalismasi.ui.theme.YaziRenk1
import com.example.tasarimcalismasi.ui.theme.YaziRenk2
import com.example.tasarimcalismasi.ui.theme.YaziRenk2Dark
import com.example.tasarimcalismasi.ui.theme.pacifico

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasarimCalismasiTheme {
                Anasayfa()
            }
        }
    }
}

//Left - Start - Leading
//Right - End - Trailing
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(darkTheme: Boolean = isSystemInDarkTheme()) {
    val configuration = LocalConfiguration.current
    val ekranYuksekligi = configuration.screenHeightDp
    val ekranGenisligi = configuration.screenWidthDp

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Pizza", fontFamily = pacifico) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (darkTheme ) AnaRenkDark else AnaRenk,
                    titleContentColor = YaziRenk1
                )
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                stringResource(id = R.string.pizzaBaslik), color = if (darkTheme ) AnaRenkDark else AnaRenk,
                fontWeight = FontWeight.Bold, fontSize = (ekranGenisligi/10).sp)
            Image(painter = painterResource(id = R.drawable.pizza_resim),
                contentDescription = "")
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                Chip(icerik = stringResource(id = R.string.peynirYazi))
                Chip(icerik = stringResource(id = R.string.sucukYazi))
                Chip(icerik = stringResource(id = R.string.zeytinYazi))
                Chip(icerik = stringResource(id = R.string.biberYazi))
            }

            Text(stringResource(id = R.string.teslimatSure), color = if (darkTheme ) YaziRenk2Dark else YaziRenk2,
                fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(stringResource(id = R.string.teslimatBaslik), color = if (darkTheme ) AnaRenkDark else AnaRenk,
                fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(stringResource(id = R.string.pizzaAciklama),
                color = if (darkTheme ) YaziRenk2Dark else YaziRenk2, fontSize = 22.sp, textAlign = TextAlign.Center)

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = (ekranGenisligi/20).dp, end = (ekranGenisligi/20).dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(stringResource(id = R.string.fiyatYazi), color = if (darkTheme ) AnaRenkDark else AnaRenk,
                    fontWeight = FontWeight.Bold, fontSize = 44.sp)
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (darkTheme ) AnaRenkDark else AnaRenk,
                        contentColor = YaziRenk1
                    )
                ) {
                    Text(text = stringResource(id = R.string.buttonYazi), fontSize = 18.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    TasarimCalismasiTheme {
        Anasayfa()
    }
}