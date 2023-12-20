package com.pokedexdf.ui.screens.pokemon_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokedexdf.domain.feature.PokemonRepositoryFeature
import com.pokedexdf.domain.states.PokemonDetailView
import com.pokedexdf.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepositoryFeature
): ViewModel(){

    private val _state = MutableSharedFlow<PokemonDetailView>()
    val state = _state.asSharedFlow()

    suspend fun getPokemonDetails(pokemonName:String) {
        viewModelScope.launch {
            when(val pokemonInfo = repository.getPokemonDetail(pokemonName)){
                is Resource.Error -> {
                    pokemonInfo.message?.let {
                        _state.emit(PokemonDetailView.DisplayErrorView(message = it))
                    }
                }
                is Resource.Loading -> {
                    _state.emit(PokemonDetailView.DisplayLoadingView)
                }
                is Resource.Success ->  {
                    pokemonInfo.data?.let {
                        _state.emit(PokemonDetailView.DisplayPokemonView(data = it))
                    }
                }

                else -> {}
            }
        }
    }
}