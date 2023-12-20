package com.pokedexdf.ui.screens.pokemon_detail.composables.pokemon_body

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.pokedexdf.ui.theme.Nunito

@Composable
fun PokemonId(id: Int) {

    Text(
        text = "#${id}",
        fontSize = 30.sp,
        fontFamily = Nunito,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.onSurface
    )
}