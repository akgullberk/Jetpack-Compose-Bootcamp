package com.example.filmlerapp.di

import com.example.filmlerapp.data.datasource.FilmlerDataSource
import com.example.filmlerapp.data.repo.FilmlerRepository
import com.example.filmlerapp.retrofit.ApiUtils
import com.example.filmlerapp.retrofit.FilmlerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFilmlerRepository(fds:FilmlerDataSource) : FilmlerRepository {
        return  FilmlerRepository(fds)
    }

    @Provides
    @Singleton
    fun provideFilmlerDataSource(fdao:FilmlerDao) : FilmlerDataSource {
        return  FilmlerDataSource(fdao)
    }

    @Provides
    @Singleton
    fun provideFilmlerDao() : FilmlerDao {
        return ApiUtils.getFilmlerDao()
    }
}