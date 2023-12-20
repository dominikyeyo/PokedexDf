package com.pokedexdf.ui.screens.pokemon_detail.composables.pokemon_body

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pokedexdf.ui.theme.Nunito
import com.pokedexdf.util.PokemonUtils.capitalizeText

@Composable
fun PokemonName(name: String) {

    val pokemonName = capitalizeText(name)

    Text(
        text = "$pokemonName",
        fontSize = 30.sp,
        fontFamily = Nunito,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.onSurface
    )
}

@Preview
@Composable
private fun CurrentScreen() {
    PokemonName( "Charmander")
}