package com.pokedexdf.data.implementation

import com.pokedexdf.data.remote.PokeApi
import com.pokedexdf.data.remote.responses.Pokemon
import com.pokedexdf.data.remote.responses.PokemonList
import com.pokedexdf.domain.feature.PokemonRepositoryFeature
import com.pokedexdf.util.Resource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PokemonRepositoryFeatureImpl @Inject constructor(
    private val api: PokeApi
) : PokemonRepositoryFeature {
    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonDetail(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}