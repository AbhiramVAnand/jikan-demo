package com.abhiram.jikan_demo.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.abhiram.jikan_demo.R
import com.abhiram.jikan_demo.domain.model.Data
import com.abhiram.jikan_demo.presentation.home.components.AnimeCard
import com.abhiram.jikan_demo.presentation.home.components.ShimmeringItem
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    list: Flow<PagingData<Data>>,
    onItemClick : (id : Int) -> Unit
) {
    val animeList = list.collectAsLazyPagingItems()
    var isLoading by remember { mutableStateOf(false) }
    isLoading = animeList.loadState.refresh is LoadState.Loading || animeList.loadState.append is LoadState.Loading

    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        item{
            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = modifier.padding(horizontal = 21.dp).padding(top = 28.dp)
            )
        }
        items(animeList.itemCount){ item ->
            ShimmeringItem(
                isLoading,
                {
                    AnimeCard(
                        animeList[item]!!,
                        onItemClick
                    )
                },
                modifier
            )
        }
    }

    animeList.apply {
        when {
            loadState.refresh is LoadState.Loading -> {
                Log.e("Status", "Loading refresh....")
            }
            loadState.append is LoadState.Loading -> {
                Log.e("Status", "Loading append....")
            }
            loadState.append is LoadState.Error -> {
                Log.e("Status", "Error...")
            }
        }
    }
}