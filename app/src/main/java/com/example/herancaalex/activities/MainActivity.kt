package com.example.herancaalex.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.herancaalex.Automovel
import com.example.herancaalex.Carro
import com.example.herancaalex.R
import com.example.herancaalex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonInserir.setOnClickListener(this)
        binding.buttonMostrar.setOnClickListener(this)
        binding.buttonRemover.setOnClickListener(this)
        binding.buttonAlterar.setOnClickListener(this)

        val veiculos = mutableListOf<Automovel>()


        val carro = ArrayList<Carro>()
        carro.add(Carro("Celta", "Chevrolet", true))

    }

    override fun onClick(view: View) {
        when(view.id) {

            R.id.button_inserir -> {
                startActivity(Intent(this, InserirActivity::class.java))
            }
            R.id.button_mostrar -> {
                startActivity(Intent(this, MostrarActivity::class.java))
            }
            R.id.button_remover -> {
                startActivity(Intent(this, RemoverActivity::class.java))
            }
            R.id.button_alterar -> {
                startActivity(Intent(this, AlterarActivity::class.java))
            }

        }
    }
}