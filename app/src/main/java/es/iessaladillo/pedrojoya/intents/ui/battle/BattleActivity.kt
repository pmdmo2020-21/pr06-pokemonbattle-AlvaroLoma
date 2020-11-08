package es.iessaladillo.pedrojoya.intents.ui.battle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.R
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.ui.selection.SelectionActivity

import es.iessaladillo.pedrojoya.intents.ui.winner.WinnerActivity


class BattleActivity : AppCompatActivity() {

    private val dateSelectionCall1 =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val resultIntent = result.data
            if (result.resultCode == Activity.RESULT_OK && resultIntent != null) {
                cargarPokemon1(resultIntent)
            }

        }
    private val dateSelectionCall2 =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val resultIntent = result.data
            if (result.resultCode == Activity.RESULT_OK && resultIntent != null) {
                cargarPokemon2(resultIntent)
            }

        }

    private lateinit var binding: BattleActivityBinding
    private lateinit var primerPokemon: Pokemon
    private lateinit var segundoPokemon: Pokemon
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.battle_activity)
        binding = BattleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        primerPokemon = Database.getRandomPokemon()
        segundoPokemon = Database.getRandomPokemon()
        binding.imagenPokemon1.setImageResource(primerPokemon.getImagen())
        binding.nombrePokemon1.text = primerPokemon.getNombre()
        binding.imagenPokemon2.setImageResource(segundoPokemon.getImagen())
        binding.nombrePokemon2.text = segundoPokemon.getNombre()
        binding.boton.setOnClickListener(View.OnClickListener { batalla() })
        binding.pokemon1.setOnClickListener { cambiarPokemon1(primerPokemon.getId()) }
        binding.pokemon2.setOnClickListener { cambiarPokemon2(segundoPokemon.getId()) }
    }

    private fun cambiarPokemon1(id: Long) {
        //startActivity(SelectionActivity.newIntent(this,id))
        dateSelectionCall1.launch(SelectionActivity.newIntent(this, id))

    }

    private fun cambiarPokemon2(id: Long) {
        //startActivity(SelectionActivity.newIntent(this,id))
        dateSelectionCall2.launch(SelectionActivity.newIntent(this, id))

    }

    private fun batalla() {
        var pokemonGanador: Pokemon
        if (primerPokemon.getFuerza() > segundoPokemon.getFuerza()) {
            pokemonGanador = primerPokemon
        } else {
            pokemonGanador = segundoPokemon
        }
        startActivity(
            WinnerActivity.newIntent(
                this,
                pokemonGanador.getNombre(),
                pokemonGanador.getImagen()
            )
        )
    }

    private fun cargarPokemon1(resultIntent: Intent) {
        var id = resultIntent.getLongExtra("ID", 0)
        var pokemon = Database.getPokemonById(id)
        if (pokemon != null) {
            binding.nombrePokemon1.text = pokemon.getNombre()
            binding.imagenPokemon1.setImageResource(pokemon.getImagen())
            primerPokemon = pokemon
        }


    }

    private fun cargarPokemon2(resultIntent: Intent) {
        var id = resultIntent.getLongExtra("ID", 0)
        var pokemon = Database.getPokemonById(id)
        if (pokemon != null) {
            binding.nombrePokemon2.text = pokemon.getNombre()
            binding.imagenPokemon2.setImageResource(pokemon.getImagen())
            segundoPokemon = pokemon
        }


    }

}