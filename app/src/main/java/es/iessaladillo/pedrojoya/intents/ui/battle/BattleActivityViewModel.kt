package es.iessaladillo.pedrojoya.intents.ui.battle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
private const val PRIMER_POKEMON="PRIMER_POKEMON"
private const val SEGUNDO_POKEMON="SEGUNDO_POKEMON"
class BattleActivityViewModel(savedStateHandle: SavedStateHandle):ViewModel()  {


    private val _primerPokemon: MutableLiveData<Pokemon> = savedStateHandle.getLiveData(PRIMER_POKEMON,Database.getRandomPokemon())
    val primerPokemon :LiveData<Pokemon> get() = _primerPokemon
    private val _segundoPokemon: MutableLiveData<Pokemon> = savedStateHandle.getLiveData(SEGUNDO_POKEMON,Database.getRandomPokemon())
    val segundoPokemon: LiveData<Pokemon> get() = _segundoPokemon

    fun batalla(primerPokemon: Pokemon, segundoPokemon: Pokemon):Pokemon {
        var pokemonGanador: Pokemon
        actualizarPokemon1(primerPokemon)
        actualizarPokemon2(segundoPokemon)
        if (primerPokemon.fuerza > segundoPokemon.fuerza) {
            pokemonGanador = primerPokemon
        } else {
            pokemonGanador = segundoPokemon
        }
        return pokemonGanador
    }

    fun actualizarPokemon1(pokemon: Pokemon) {
        _primerPokemon.value=pokemon
    }
    fun actualizarPokemon2(pokemon: Pokemon) {
        _segundoPokemon.value=pokemon
    }

}