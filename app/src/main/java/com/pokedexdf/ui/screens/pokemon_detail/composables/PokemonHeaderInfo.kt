package com.pokedexdf.ui.screens.pokemon_detail.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pokedexdf.R
import com.pokedexdf.domain.states.PokemonDetailView
import com.pokedexdf.ui.screens.common.composables.PokemonErrorBlock

@Composable
fun PokemonHeaderInfo(
    pokemonDetailView: PokemonDetailView,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    when (pokemonDetailView) {
        is PokemonDetailView.DisplayPokemonView -> {
            PokemonHeader(
                pokemonInfo = pokemonDetailView.data,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f),
            )

        }

        is PokemonDetailView.DisplayErrorView -> {
            PokemonErrorBlock(
                text = stringResource(id = R.string.str_something_went_wrong),
                image = painterResource(R.drawable.ic_something_went_wrong),
                onActionClick = onClick
            )
        }

        PokemonDetailView.DisplayLoadingView -> {
            // LoadingView()
        }

        else -> {}
    }
}