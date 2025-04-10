package com.abhiram.jikan_demo.di

import com.abhiram.jikan_demo.data.repository.AnimeRepositoryImpl
import com.abhiram.jikan_demo.domain.repository.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAnimeRepository(
        impl: AnimeRepositoryImpl
    ) : AnimeRepository

}