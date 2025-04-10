package com.abhiram.jikan_demo.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.abhiram.jikan_demo.data.remote.AnimeSource
import com.abhiram.jikan_demo.domain.model.Data
import com.abhiram.jikan_demo.domain.repository.AnimeRepository
import com.example.example.AnimeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repo : AnimeRepository,
    private val animeSource: AnimeSource
) : ViewModel(){

    val animesList : Flow<PagingData<Data>> = Pager(PagingConfig(pageSize = 6)){
        animeSource
    }.flow.cachedIn(viewModelScope)

    private val _anime = mutableStateOf<AnimeData?>(null)
    val anime : MutableState<AnimeData?> = _anime

    fun getAnime(id : Int){
        val call = repo.getAnimeById(id.toString())
        call.enqueue(object : Callback<AnimeData> {
            override fun onResponse(p0: Call<AnimeData>, p1: Response<AnimeData>) {
                Log.e("Response", p1.body().toString())
                _anime.value = p1.body()
            }

            override fun onFailure(p0: Call<AnimeData>, p1: Throwable) {
                Log.e("Error", p1.message.toString())
            }

        })
    }
}