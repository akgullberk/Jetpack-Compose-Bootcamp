package com.example.filmlerapp.data.repo

import com.example.filmlerapp.data.datasource.FilmlerDataSource
import com.example.filmlerapp.data.entity.Filmler

class FilmlerRepository(var fds:FilmlerDataSource) {

    suspend fun filmleriYukle() : List<Filmler> = fds.filmleriYukle()
}