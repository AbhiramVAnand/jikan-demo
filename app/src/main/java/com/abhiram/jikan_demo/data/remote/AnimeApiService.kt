package com.abhiram.jikan_demo.data.remote

import com.abhiram.jikan_demo.domain.model.ApiResponse
import com.example.example.AnimeData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {
    @GET("/v4/top/anime")
    suspend fun getAnimes(@Query("page") page : Int): ApiResponse

    @GET("/v4/anime/{id}")
    fun getAnimeById(@Path("id") id: String): Call<AnimeData>
}