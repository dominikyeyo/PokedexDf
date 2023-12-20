package com.pokedexdf.ui.screens.common.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pokedexdf.R

@Composable
fun PokemonErrorBlock(
    modifier: Modifier = Modifier,
    text: String = stringResource(id = R.string.str_something_went_wrong),
    image : Painter = painterResource(id = R.drawable.ic_something_went_wrong),
    onActionClick:() -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            modifier = Modifier.size(50.dp),
            contentDescription = text
        )
        Text(
            text = text,
            fontSize = 14.sp,
            color = MaterialTheme.colors.surface
        )
        Button(onClick = onActionClick) {
            Text(
                text = stringResource(id = R.string.str_try_again),
                color = MaterialTheme.colors.surface
            )
        }
    }

}