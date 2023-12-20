package com.pokedexdf.ui.screens.pokemon_detail.composables.pokemon_body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pokedexdf.R
import com.pokedexdf.util.PokemonUtils.weightHeightMeasurement

@Composable
fun PokemonAttributes(
    pokemonWeight: Float,
    pokemonHeight: Float,
    pokemonAbilities: String,
    pokemonSpecie: String
) {
    val weight = remember { weightHeightMeasurement(pokemonWeight)}
    val height = remember { weightHeightMeasurement(pokemonHeight)}
    val abilities = remember { pokemonAbilities }
    val specie = remember { pokemonSpecie}

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.str_weight)
                    + " : " +
                    weight
                    +stringResource(id = R.string.str_kg)
        )
        Text(
            text = stringResource(id = R.string.str_height)
                    + " : " +
                    height
                    +stringResource(id = R.string.str_meter)
        )
        Text(
            text = stringResource(id = R.string.str_abilities)
                    + " : " +
                    abilities
        )
        Text(
            text = stringResource(id = R.string.str_specie)
                    + " : " +
                    specie
        )
    }
}