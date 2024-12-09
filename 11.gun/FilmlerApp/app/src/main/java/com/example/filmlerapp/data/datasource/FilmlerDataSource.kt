package com.example.filmlerapp.data.datasource

import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.retrofit.FilmlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource(var fdao:FilmlerDao) {

    suspend fun filmleriYukle() : List<Filmler> = withContext(Dispatchers.IO){
        return@withContext fdao.filmleriYukle().filmler
    }
}