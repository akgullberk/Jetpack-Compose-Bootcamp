package com.example.hiltkullanimi

import android.util.Log
import javax.inject.Inject

class Kargo @Inject constructor(var adres: Adres) {


    fun  gonder(){
        Log.e("Sonuç" , "${adres.bilgi} adresine kargo gönderildi")
    }
}