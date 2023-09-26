package com.example.herancaalex.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.herancaalex.Automovel
import com.example.herancaalex.Caminhao
import com.example.herancaalex.Carro
import com.example.herancaalex.Onibus
import com.example.herancaalex.R
import com.example.herancaalex.databinding.ActivityInserirBinding
import com.example.herancaalex.databinding.ActivityMainBinding

class InserirActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener,
    View.OnClickListener {

    lateinit var binding: ActivityInserirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInserirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioOnibus.setOnClickListener(this)
        binding.radioCarro.setOnClickListener(this)
        binding.radioCaminhao.setOnClickListener(this)
        binding.buttonInserirInserir.setOnClickListener(this)

    }

    var veiculos = mutableListOf<Automovel>()

    override fun onClick(view: View) {
        when (view.id) {
            R.id.radio_onibus -> {

                binding.inputsCarro.isInvisible = true
                binding.inputsCaminhao.isInvisible = true
                binding.inputsOnibus.isInvisible = false

            }

            R.id.radio_carro -> {

                binding.inputsCaminhao.isInvisible = true
                binding.inputsOnibus.isInvisible = true
                binding.inputsCarro.isInvisible = false
            }

            R.id.radio_caminhao -> {
                binding.inputsCaminhao.isInvisible = false
                binding.inputsOnibus.isInvisible = true
                binding.inputsCarro.isInvisible = true
            }

            R.id.button_inserir_inserir -> {
                pegarDadoseInserir(view)
                toastDados()
            }

        }

    }

    fun pegarDadoseInserir(view: View) {

        var nome = ""
        var marca = ""
        var qtd_lugares = ""
        var banheiro = false
        var completo = false
        var peso_suportado = 0f

        when(view.id) {
            R.id.radio_onibus -> {
                nome = binding.editNomeDoOnibus.text.toString()
                marca = binding.editMarcaDoOnibus.text.toString()
                qtd_lugares = binding.editQtdLugares.text.toString()
                banheiro = if (binding.radioSim.isChecked) true
                else false

                veiculos.add(Onibus(nome,marca,qtd_lugares.toInt(),banheiro))
            }
            R.id.radio_carro -> {
                nome = binding.editNomeDoCarro.text.toString()
                marca = binding.editMarcaDoCarro.text.toString()
                completo = if (binding.radioCompleto.isChecked) true
                else  false

                veiculos.add(Carro(nome,marca,completo))
            }
            R.id.radio_caminhao -> {
                nome = binding.editNomeDoCaminhao.text.toString()
                marca = binding.editMarcaDoCaminhao.text.toString()
                peso_suportado = binding.editPesoSuportado.text.toString().toFloat()

                veiculos.add(Caminhao(nome,marca,peso_suportado))
            }

        }

    }


    fun toastDados() {
        Toast.makeText(this,veiculos.toString(),Toast.LENGTH_SHORT).show()
    }
    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        TODO("Not yet implemented")
    }



}

