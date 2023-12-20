package com.pokedexdf.data.remote.pagin

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.pokedexdf.data.remote.PokeApi
import com.pokedexdf.util.Constants.PAGE_SIZE
import javax.inject.Inject


class PagingRepository @Inject constructor(
    private val api: PokeApi
) {
    fun getPokemon() = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        pagingSourceFactory = {
            PokemonPagingSource(api)
        }

    ).flow
}