package com.abhiram.jikan_demo.data.repository

import android.util.Log
import com.abhiram.jikan_demo.data.remote.AnimeApiService
import com.abhiram.jikan_demo.domain.model.ApiResponse
import com.abhiram.jikan_demo.domain.model.Data
import com.abhiram.jikan_demo.domain.repository.AnimeRepository
import com.example.example.AnimeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val animeApiService : AnimeApiService
) : AnimeRepository{
    override fun getAnimeById(id: String): Call<AnimeData> = animeApiService.getAnimeById(id)
}