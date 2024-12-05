package com.example.hiltkullanimi

import android.util.Log
import javax.inject.Inject

class Internet @Inject constructor(var adres: Adres) {

    fun  basvuru(){
        Log.e("Sonuç" , "${adres.bilgi} adresine basvuru yapıldı")
    }
}