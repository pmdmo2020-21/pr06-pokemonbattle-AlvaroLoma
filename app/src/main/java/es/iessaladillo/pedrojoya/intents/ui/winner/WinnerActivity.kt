package es.iessaladillo.pedrojoya.intents.ui.winner

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.databinding.WinnerActivityBinding


class WinnerActivity : AppCompatActivity() {
    companion object {
        const val NOMBRE = "NOMBRE"
        const val IMAGEN = "IMAGEN"
        fun newIntent(context: Context, nombre: String, imagen: Int): Intent {
            return Intent(context, WinnerActivity::class.java)
                .putExtra(NOMBRE, nombre)
                .putExtra(IMAGEN, imagen)

        }
    }

    private var nombreGanador: String = ""
    private var imagenGanador: Int = 0
    private lateinit var binding: WinnerActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WinnerActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        reciveData()
        setupView()
    }

    private fun setupView() {
        binding.nombreGanador.text = nombreGanador
        binding.imagenGanador.setImageResource(imagenGanador)
    }

    private fun reciveData() {
        imagenGanador = intent.getIntExtra("IMAGEN", 0)
        nombreGanador = intent.getStringExtra("NOMBRE").toString()
    }

}