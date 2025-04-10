package com.abhiram.jikan_demo.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.abhiram.jikan_demo.domain.model.Data

@Composable
fun AnimeCard(animeItem: Data, onClick : (id : Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick(animeItem.mal_id) }
            .padding(horizontal = 21.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .border(1.dp, Color(0x77FFFFFF), RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = rememberAsyncImagePainter(animeItem.images.jpg.image_url),
                contentDescription = "imageposter",
                modifier = Modifier.fillMaxHeight()
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1F)
                .padding(end = 12.dp, top = 8.dp, bottom = 12.dp),
        ) {
            Text(
                text = animeItem.title,
                modifier = Modifier.weight(1F),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "No: of episodes: " + animeItem.episodes.toString(),
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Rating: " + animeItem.score.toString() + "/10",
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}