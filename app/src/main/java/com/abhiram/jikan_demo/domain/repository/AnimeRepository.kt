package com.abhiram.jikan_demo.domain.repository


import com.abhiram.jikan_demo.domain.model.ApiResponse
import com.abhiram.jikan_demo.domain.model.Data
import com.example.example.AnimeData
import retrofit2.Call

interface AnimeRepository {
    fun getAnimeById(id : String) : Call<AnimeData>
}