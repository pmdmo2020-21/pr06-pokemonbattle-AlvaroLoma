package es.iessaladillo.pedrojoya.intents.ui.battle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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
                viewModel.actualizarPokemon1(resultIntent.getParcelableExtra<Pokemon>("POKEMON")!!)
            }

        }
    private val dateSelectionCall2 =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val resultIntent = result.data
            if (result.resultCode == Activity.RESULT_OK && resultIntent != null) {
                viewModel.actualizarPokemon2(resultIntent.getParcelableExtra<Pokemon>("POKEMON")!!)
            }

        }
    private val viewModel: BattleActivityViewModel by viewModels()
    private lateinit var binding: BattleActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.battle_activity)
        binding = BattleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        observables()
    }

    private fun observables() {
        viewModel.primerPokemon.observe(this, { nuevoPokemon1(it) })
        viewModel.segundoPokemon.observe(this, { nuevoPokemon2(it) })

    }

    private fun setupViews() {
        binding.boton.setOnClickListener(View.OnClickListener {
            batalla(
                viewModel.batalla(
                    viewModel.primerPokemon.value!!,
                    viewModel.segundoPokemon.value!!
                )
            )
        })
        binding.pokemon1.setOnClickListener { cambiarPokemon1() }
        binding.pokemon2.setOnClickListener { cambiarPokemon2() }

    }

    private fun nuevoPokemon2(pokemon: Pokemon) {
        binding.nombrePokemon2.text = pokemon.nombre
        binding.imagenPokemon2.setImageResource(pokemon.imagen)
    }

    private fun nuevoPokemon1(pokemon: Pokemon) {
        binding.nombrePokemon1.text = pokemon.nombre
        binding.imagenPokemon1.setImageResource(pokemon.imagen)
    }

    private fun cambiarPokemon1() {
        //startActivity(SelectionActivity.newIntent(this,id))
        dateSelectionCall1.launch(
            SelectionActivity.newIntent(
                this,
                viewModel.primerPokemon.value!!
            )
        )

    }

    private fun cambiarPokemon2() {
        //startActivity(SelectionActivity.newIntent(this,id))
        dateSelectionCall2.launch(
            SelectionActivity.newIntent(
                this,
                viewModel.segundoPokemon.value!!
            )
        )
    }

    private fun batalla(pokemon: Pokemon) {
        startActivity(WinnerActivity.newIntent(this, pokemon))
    }


}