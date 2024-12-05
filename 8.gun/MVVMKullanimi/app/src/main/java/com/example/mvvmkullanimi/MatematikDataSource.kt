package com.example.mvvmkullanimi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatematikDataSource {
    suspend fun topla(alinanSayi1:String,alinanSayi2: String) : String = withContext(Dispatchers.IO){
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val toplam = sayi1 + sayi2

        return@withContext toplam.toString()
    }

    suspend fun carp(alinanSayi1:String,alinanSayi2: String) : String = withContext(Dispatchers.IO){
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val carpma = sayi1 * sayi2

        return@withContext carpma.toString()
    }
}