package com.pokedexdf.data.remote.pagin

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pokedexdf.data.remote.PokeApi
import com.pokedexdf.data.remote.models.PokedexListEntry
import com.pokedexdf.util.Constants.PAGE_SIZE
import com.pokedexdf.util.PokemonUtils
import com.pokedexdf.util.PokemonUtils.capitalizeText

class PokemonPagingSource(
    private val api: PokeApi,
) : PagingSource<Int, PokedexListEntry>() {

    override fun getRefreshKey(state: PagingState<Int, PokedexListEntry>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokedexListEntry> {
        return try {

            val page = params.key ?: 1
            val offset = ((page-1) * PAGE_SIZE + 1)-1;
            val response = api.getPokemonList(PAGE_SIZE, offset) //TODO: Here get api pokemon

            val resultPokemon = response.results.mapIndexed { _, entry ->
                val number = PokemonUtils.getPokemonNumber(entry)
                val url = PokemonUtils.formatPokemonUrl(entry.url)
                PokedexListEntry(capitalizeText(entry.name), url, number.toInt())
            }

            LoadResult.Page(
                data = resultPokemon,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}