package es.iessaladillo.pedrojoya.intents.ui.winner

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.databinding.WinnerActivityBinding


class WinnerActivity : AppCompatActivity() {
    companion object {
        const val POKEMON = "POKEMON"

        fun newIntent(context: Context,pokemon: Pokemon): Intent {
            return Intent(context, WinnerActivity::class.java)
                .putExtra(POKEMON,pokemon)

        }
    }

    private lateinit var pokemonGanador:Pokemon
    private lateinit var binding: WinnerActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WinnerActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        reciveData()
        setupView()
    }

    private fun setupView() {
        binding.nombreGanador.text =pokemonGanador.nombre
        binding.imagenGanador.setImageResource(pokemonGanador.imagen)
    }

    private fun reciveData() {
        pokemonGanador= intent.getParcelableExtra<Pokemon>(POKEMON)!!
    }

}