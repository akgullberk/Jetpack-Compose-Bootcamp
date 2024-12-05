package com.example.mvvmkullanimi

class MatematikRepository {
    var mds = MatematikDataSource()

    suspend fun topla(alinanSayi1:String,alinanSayi2: String) : String = mds.topla(alinanSayi1,alinanSayi2)

    suspend fun carp(alinanSayi1:String,alinanSayi2: String) : String = mds.carp(alinanSayi1,alinanSayi2)
}