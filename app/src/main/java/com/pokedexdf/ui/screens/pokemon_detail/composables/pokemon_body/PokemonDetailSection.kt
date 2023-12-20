package com.pokedexdf.ui.screens.pokemon_detail.composables.pokemon_body

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pokedexdf.data.remote.responses.Pokemon
import java.util.Locale

@Composable
fun PokemonDetailSection(
    pokemonInfo: Pokemon,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .offset(y = 100.dp)
            .verticalScroll(scrollState)
    ) {
        val abilities = pokemonInfo.abilities.joinToString(separator = ", ") {
            it.ability.name.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
        }
        PokemonName(name = pokemonInfo.name)
        PokemonTypes(types = pokemonInfo.types)
        Spacer(modifier = Modifier.height(20.dp))
        PokemonAttributes(
            pokemonWeight = pokemonInfo.weight,
            pokemonHeight = pokemonInfo.height,
            pokemonAbilities = abilities,
            pokemonSpecie = pokemonInfo.species.name,

            )
    }
}