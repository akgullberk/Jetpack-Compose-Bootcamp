package com.example.mvvmkullanimi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {
    var sonuc = MutableLiveData("0")
    var mrepo = MatematikRepository()

    fun topla(alinanSayi1:String,alinanSayi2: String){
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = mrepo.topla(alinanSayi1,alinanSayi2)
        }
    }

    fun carp(alinanSayi1:String,alinanSayi2: String){
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = mrepo.carp(alinanSayi1,alinanSayi2)
        }
    }
}