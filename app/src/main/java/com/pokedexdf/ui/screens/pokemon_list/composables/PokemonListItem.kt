package com.pokedexdf.ui.screens.pokemon_list.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.pokedexdf.R
import com.pokedexdf.data.remote.models.PokedexListEntry
import com.pokedexdf.ui.screens.pokemon_list.PokemonListViewModel
import com.pokedexdf.ui.theme.Nunito

@Composable
fun PokemonListItem(
    item: PokedexListEntry,
    onItemClick: (PokedexListEntry) -> Unit,
    viewModel: PokemonListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val defaultColor = Color.White
    var pokemonDominantColor by remember { mutableStateOf(defaultColor) }

    Box(
        modifier = Modifier
            .height(200.dp)
            .padding(5.dp)
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(pokemonDominantColor)
            .clickable {
                item.dominentColor = pokemonDominantColor
                onItemClick(item)
            }
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = item.pokemonName,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(250.dp),
            onSuccess = { success ->
                val drawable = success.result.drawable
                viewModel.calcDominantColor(drawable) { pokemonDominantColor = it }
            }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = item.pokemonName,
                style = TextStyle(
                    color = colorResource(id = R.color.cardText),
                    fontSize = 18.sp,
                    fontFamily = Nunito,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}