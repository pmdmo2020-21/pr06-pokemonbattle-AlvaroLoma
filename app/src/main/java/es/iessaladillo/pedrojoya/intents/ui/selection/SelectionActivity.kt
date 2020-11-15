package es.iessaladillo.pedrojoya.intents.ui.selection

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.SelectionActivityBinding
import es.iessaladillo.pedrojoya.intents.ui.battle.BattleActivity
import es.iessaladillo.pedrojoya.intents.ui.winner.WinnerActivity

class SelectionActivity : AppCompatActivity() {
    private lateinit var pokemon: Pokemon
    private lateinit var binding: SelectionActivityBinding

    companion object {
        const val POKEMON = "POKEMON"
        fun newIntent(context: Context, pokemon: Pokemon): Intent {
            return Intent(context, SelectionActivity::class.java)
                .putExtra(POKEMON, pokemon)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SelectionActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
        reciveData()
        seleccionarPokemon()

    }

    private fun setUpView() {
        cargarNombres()
        cargarBotones()
        cargarImagenes()
    }

    private fun cargarImagenes() {
        binding.imagenPokemon1.setOnClickListener(View.OnClickListener { cargarPokemon1() })
        binding.imagenPokemon2.setOnClickListener(View.OnClickListener { cargarPokemon2() })
        binding.imagenPokemon3.setOnClickListener(View.OnClickListener { cargarPokemon3() })
        binding.imagenPokemon4.setOnClickListener(View.OnClickListener { cargarPokemon4() })
        binding.imagenPokemon5.setOnClickListener(View.OnClickListener { cargarPokemon5() })
        binding.imagenPokemon6.setOnClickListener(View.OnClickListener { cargarPokemon6() })
    }

    private fun cargarBotones() {
        binding.botonPokemon1.setOnClickListener(View.OnClickListener { cargarPokemon1() })
        binding.botonPokemon2.setOnClickListener(View.OnClickListener { cargarPokemon2() })
        binding.botonPokemon3.setOnClickListener(View.OnClickListener { cargarPokemon3() })
        binding.botonPokemon4.setOnClickListener(View.OnClickListener { cargarPokemon4() })
        binding.botonPokemon5.setOnClickListener(View.OnClickListener { cargarPokemon5() })
        binding.botonPokemon6.setOnClickListener(View.OnClickListener { cargarPokemon6() })
    }

    private fun cargarNombres() {
        var pokedex = Database.getAllPokemons()
        var iterador = pokedex.listIterator()
        var pokemon=iterador.next()
        binding.botonPokemon1.text = pokemon.nombre
        binding.imagenPokemon1.setImageResource(pokemon.imagen)
        pokemon=iterador.next()
        binding.botonPokemon2.text = pokemon.nombre
        binding.imagenPokemon2.setImageResource(pokemon.imagen)
        pokemon=iterador.next()
        binding.botonPokemon3.text = pokemon.nombre
        binding.imagenPokemon3.setImageResource(pokemon.imagen)
        pokemon=iterador.next()
        binding.botonPokemon4.text = pokemon.nombre
        binding.imagenPokemon4.setImageResource(pokemon.imagen)
        pokemon=iterador.next()
        binding.botonPokemon5.text = pokemon.nombre
        binding.imagenPokemon5.setImageResource(pokemon.imagen)
        pokemon=iterador.next()
        binding.botonPokemon6.text = pokemon.nombre
        binding.imagenPokemon6.setImageResource(pokemon.imagen)
    }

    private fun cargarPokemon1() {

        for (pokemon1 in Database.getAllPokemons()) {
            if (pokemon1.nombre == binding.botonPokemon1.text) {
                pokemon =pokemon1
            }
        }
        apagarBotones()
        binding.botonPokemon1.isChecked = true

    }

    private fun cargarPokemon2() {
        var pokedex = Database.getAllPokemons()

        for (pokemon1 in pokedex) {
            if (pokemon1.nombre == binding.botonPokemon2.text) {
                pokemon =pokemon1
            }
        }
        apagarBotones()
        binding.botonPokemon2.isChecked = true
    }

    private fun cargarPokemon3() {
        var pokedex = Database.getAllPokemons()

        for (pokemon1 in pokedex) {
            if (pokemon1.nombre == binding.botonPokemon3.text) {
                pokemon =pokemon1
            }
        }
        apagarBotones()
        binding.botonPokemon3.isChecked = true
    }

    private fun cargarPokemon4() {
        var pokedex = Database.getAllPokemons()

        for (pokemon1 in pokedex) {
            if (pokemon1.nombre == binding.botonPokemon4.text) {
                pokemon =pokemon1
            }
        }
        apagarBotones()
        binding.botonPokemon4.isChecked = true
    }

    private fun cargarPokemon5() {
        var pokedex = Database.getAllPokemons()

        for (pokemon1 in pokedex) {
            if (pokemon1.nombre == binding.botonPokemon5.text) {
                pokemon =pokemon1
            }
        }
        apagarBotones()
        binding.botonPokemon5.isChecked = true
    }

    private fun cargarPokemon6() {
        var pokedex = Database.getAllPokemons()

        for (pokemon1 in pokedex) {
            if (pokemon1.nombre == binding.botonPokemon6.text) {
                pokemon =pokemon1
            }
        }
        apagarBotones()
        binding.botonPokemon6.isChecked = true
    }

    private fun seleccionarPokemon() {
            apagarBotones()
            if (binding.botonPokemon1.text == pokemon.nombre) {
                binding.botonPokemon1.isChecked = true
            } else if (binding.botonPokemon2.text == pokemon.nombre) {
                binding.botonPokemon2.isChecked = true
            } else if (binding.botonPokemon3.text == pokemon.nombre) {
                binding.botonPokemon3.isChecked = true
            } else if (binding.botonPokemon4.text == pokemon.nombre) {
                binding.botonPokemon4.isChecked = true
            } else if (binding.botonPokemon5.text == pokemon.nombre) {
                binding.botonPokemon5.isChecked = true
            } else if (binding.botonPokemon6.text == pokemon.nombre) {
                binding.botonPokemon6.isChecked = true
            }



    }

    private fun apagarBotones() {
        binding.botonPokemon6.isChecked = false
        binding.botonPokemon5.isChecked = false
        binding.botonPokemon4.isChecked = false
        binding.botonPokemon3.isChecked = false
        binding.botonPokemon2.isChecked = false
        binding.botonPokemon1.isChecked = false
    }

    private fun reciveData() {
        pokemon = intent.getParcelableExtra<Pokemon>(POKEMON)!!
    }

    override fun onBackPressed() {
        val result = Intent().putExtra(POKEMON,pokemon)
        setResult(Activity.RESULT_OK, result)
        finish()
        super.onBackPressed()
    }

}