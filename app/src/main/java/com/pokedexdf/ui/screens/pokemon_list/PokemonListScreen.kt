package com.pokedexdf.ui.screens.pokemon_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.pokedexdf.data.remote.models.PokedexListEntry
import com.pokedexdf.ui.screens.pokemon_list.composables.PokemonImage
import com.pokedexdf.ui.screens.pokemon_list.composables.PokemonLazyList


@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val allPokemonList = viewModel.getPokemonList().collectAsLazyPagingItems()
    var searchQuery by remember { mutableStateOf("") }
    val filteredPokemonEntries = remember { mutableStateListOf<PokedexListEntry>() }

    LaunchedEffect(allPokemonList) {
        snapshotFlow { allPokemonList.itemSnapshotList.items }
            .collect { items ->
                filteredPokemonEntries.clear()
                filteredPokemonEntries.addAll(
                    if (searchQuery.isBlank()) {
                        items
                    } else {
                        items.filter { it.pokemonName.contains(searchQuery, ignoreCase = true) }
                    }
                )
            }
    }

    LaunchedEffect(searchQuery) {
        val items = allPokemonList.itemSnapshotList.items
        filteredPokemonEntries.clear()
        filteredPokemonEntries.addAll(
            if (searchQuery.isBlank()) {
                items
            } else {
                items.filter { it.pokemonName.contains(searchQuery, ignoreCase = true) }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        PokemonImage()
        SearchBar(
            query = searchQuery,
            onQueryChanged = { newQuery ->
                searchQuery = newQuery
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        PokemonLazyList(
            filteredPokemonList = filteredPokemonEntries,
            onItemClick = { entry ->
                navController.navigate(
                    "pokemon_detail_screen/${entry.dominentColor.toArgb()}/${entry.pokemonName}"
                )
            }
        )
    }
}

@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChanged,
        maxLines = 1,
        textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
        placeholder = { Text("Find your favorite pokemon ?") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.surface)
            .padding(horizontal = 20.dp)
    )
}