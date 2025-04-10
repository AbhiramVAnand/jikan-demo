package com.abhiram.jikan_demo.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.abhiram.jikan_demo.domain.model.Data
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AnimeSource @Inject constructor(
    val animeApiService: AnimeApiService
) : PagingSource<Int, Data>() {
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val nextPage = params.key ?: 1
            val animeList = animeApiService.getAnimes(page = nextPage)
            LoadResult.Page(
                data = animeList.data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (animeList.data.isEmpty()) null else animeList.pagination.current_page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}