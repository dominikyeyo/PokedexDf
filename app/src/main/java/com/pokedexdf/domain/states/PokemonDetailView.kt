package com.pokedexdf.domain.states

import com.pokedexdf.data.remote.responses.Pokemon

sealed class PokemonDetailView {
    data class DisplayPokemonView(val data : Pokemon):PokemonDetailView()
    data class DisplayErrorView(val message : String):PokemonDetailView()
    object DisplayLoadingView : PokemonDetailView()
}