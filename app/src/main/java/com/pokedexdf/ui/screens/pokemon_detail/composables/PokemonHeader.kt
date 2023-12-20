package com.pokedexdf.ui.screens.pokemon_detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pokedexdf.R
import com.pokedexdf.data.remote.responses.Pokemon
import com.pokedexdf.domain.states.PokemonDetailView
import com.pokedexdf.ui.theme.Nunito

@Composable
fun PokemonHeader(
    pokemonInfo: Pokemon,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(36.dp)
            )
        }



        Text(
            text = "# ${pokemonInfo.id}",
            color = Color.White,
            fontSize = 26.sp,
            fontFamily = Nunito,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )

        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_open_in_new_window),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(36.dp)
            )
        }
    }
}