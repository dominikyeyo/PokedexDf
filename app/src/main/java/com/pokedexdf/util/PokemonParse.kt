package com.pokedexdf.util

import androidx.compose.ui.graphics.Color
import com.pokedexdf.data.remote.responses.Type
import com.pokedexdf.ui.theme.TypeBug
import com.pokedexdf.ui.theme.TypeDark
import com.pokedexdf.ui.theme.TypeDragon
import com.pokedexdf.ui.theme.TypeElectric
import com.pokedexdf.ui.theme.TypeFairy
import com.pokedexdf.ui.theme.TypeFighting
import com.pokedexdf.ui.theme.TypeFire
import com.pokedexdf.ui.theme.TypeFlying
import com.pokedexdf.ui.theme.TypeGhost
import com.pokedexdf.ui.theme.TypeGrass
import com.pokedexdf.ui.theme.TypeGround
import com.pokedexdf.ui.theme.TypeIce
import com.pokedexdf.ui.theme.TypeNormal
import com.pokedexdf.ui.theme.TypePoison
import com.pokedexdf.ui.theme.TypePsychic
import com.pokedexdf.ui.theme.TypeRock
import com.pokedexdf.ui.theme.TypeSteel
import com.pokedexdf.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Type): Color {
    return when (type.type.name.lowercase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}