package com.pokedexdf.util

import com.pokedexdf.data.remote.responses.Result
import java.util.Locale
import kotlin.math.roundToInt

object PokemonUtils {

    fun formatPokemonUrl(pokemonUrl: String): String {
        val number = if (pokemonUrl.endsWith("/")) {
            pokemonUrl.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            pokemonUrl.takeLastWhile { it.isDigit() }
        }
        //TODO: return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${number}.png"
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
    }


    fun getPokemonNumber(entry: Result): String {
        val number = if(entry.url.endsWith("/")) {
            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            entry.url.takeLastWhile { it.isDigit() }
        }
        return number
    }

    fun capitalizeText(text :String): String {
        return text.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    }

    fun weightHeightMeasurement(value :Float): String {
        return ((value * 100f).roundToInt() / 1000f).toString()
    }

    fun formatPokemonDetailUrl(pokemonUrl: String): String {
        //TODO: //return pokemonUrl.replace("pokemon","pokemon/other/official-artwork/")
        return pokemonUrl.replace("pokemon","pokemon")
    }

}