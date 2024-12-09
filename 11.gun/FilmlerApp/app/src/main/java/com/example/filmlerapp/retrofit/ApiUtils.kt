package com.example.filmlerapp.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getFilmlerDao() : FilmlerDao {
            return RetrofitClient.getClient(BASE_URL).create(FilmlerDao::class.java)
        }
    }
}