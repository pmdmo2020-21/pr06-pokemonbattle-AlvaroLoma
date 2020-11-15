package es.iessaladillo.pedrojoya.intents.data.local

import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import java.util.*

// TODO: Haz que Database implemente DataSource
object Database : DataSource{

    val pokedex= listOf<Pokemon>(
        Pokemon(4,"Bulbasur",es.iessaladillo.pedrojoya.intents.R.drawable.bulbasur,1),
        Pokemon(3,"Cubone",es.iessaladillo.pedrojoya.intents.R.drawable.cubone,2),
        Pokemon(2,"Feebas",es.iessaladillo.pedrojoya.intents.R.drawable.feebas,3),
        Pokemon(10,"Giratina",es.iessaladillo.pedrojoya.intents.R.drawable.giratina,4),
        Pokemon(8,"Gyarados",es.iessaladillo.pedrojoya.intents.R.drawable.gyarados,5),
        Pokemon(5,"Pikachu",es.iessaladillo.pedrojoya.intents.R.drawable.pikachu,6)
    )
    override fun getRandomPokemon(): Pokemon {
        return pokedex.get(Random().nextInt(6))
    }

    override fun getAllPokemons(): List<Pokemon> {
        return pokedex
    }

    override fun getPokemonById(id: Long): Pokemon? {
        var pokemonElegido: Pokemon? =null
        for(pokemon in pokedex){
            if(pokemon.id==id){
                pokemonElegido= pokemon
            }
        }
        return pokemonElegido
    }

}