package com.abhiram.jikan_demo.presentation.details

import android.net.Uri
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.abhiram.jikan_demo.presentation.AnimeViewModel
import com.abhiram.jikan_demo.presentation.details.components.GenreChips
import com.abhiram.jikan_demo.presentation.details.components.TrailerScreen

@Composable
fun DetailsScreen(
    modifier: Modifier,
    id: Int,
    viewmodel: AnimeViewModel,
    navController: NavHostController
) {
    val anime by viewmodel.anime
    LaunchedEffect(id) {
        viewmodel.getAnime(id)
    }
    val genreList = mutableListOf<String>()
    if (anime == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        for (i in 0 until anime!!.data!!.genres.size) {
            genreList.add(anime!!.data!!.genres[i].name.toString())
        }
        Log.e("Error", anime.toString())
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 12.dp)
                .padding(horizontal = 21.dp, vertical = 12.dp)
                .verticalScroll(
                    rememberScrollState()
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (anime!!.data!!.trailer!!.embedUrl == null) {
                Image(
                    painter = rememberAsyncImagePainter(anime!!.data!!.images!!.imageUrl),
                    contentDescription = "imageposter",
                )
            } else {
                TrailerScreen(modifier, anime!!.data!!.trailer!!.embedUrl.toString())
            }
            Spacer(Modifier.height(12.dp))
            Text(
                text = anime!!.data!!.title.toString(),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = "No: of episodes: " + anime!!.data!!.episodes.toString(),
                color = Color.White,
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = "Rating: " + anime!!.data!!.score.toString() + "/10",
                color = Color.White,
                style = MaterialTheme.typography.labelSmall
            )
            Spacer(Modifier.height(12.dp))
            GenreChips(Modifier, genreList)
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Synopsis: \n" + anime!!.data!!.synopsis,
                color = Color.White,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(Modifier.height(12.dp))
        }
    }
}