package com.abhiram.jikan_demo.di

import com.abhiram.jikan_demo.data.remote.AnimeApiService
import com.abhiram.jikan_demo.data.remote.AnimeSource
import com.abhiram.jikan_demo.data.repository.AnimeRepositoryImpl
import com.abhiram.jikan_demo.domain.repository.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun providesAnimeApiService() : AnimeApiService = Retrofit.Builder()
        .baseUrl("https://api.jikan.moe/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AnimeApiService::class.java)

    @Provides
    @Singleton
    fun providesAnimeSource(apiService: AnimeApiService) : AnimeSource {
        return AnimeSource(apiService)
    }
}