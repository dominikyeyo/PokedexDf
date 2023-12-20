package com.pokedexdf.domain.feature

import com.pokedexdf.data.remote.responses.Pokemon
import com.pokedexdf.data.remote.responses.PokemonList
import com.pokedexdf.util.Resource

interface PokemonRepositoryFeature {
    /**
     * Getting a list of pokemon
     */
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>

    /**
     * Getting details of pokemon
     */
    suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon>
}