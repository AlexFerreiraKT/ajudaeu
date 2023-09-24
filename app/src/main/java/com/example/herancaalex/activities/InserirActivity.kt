package com.example.herancaalex.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.herancaalex.R
import com.example.herancaalex.databinding.ActivityInserirBinding
import com.example.herancaalex.databinding.ActivityMainBinding

class InserirActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    lateinit var binding: ActivityInserirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInserirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioOnibus.setOnCheckedChangeListener(this)
        binding.radioCaminhao.setOnCheckedChangeListener(this)
        binding.radioCarro.setOnCheckedChangeListener(this)


    }

    override fun onCheckedChanged(button: CompoundButton, isChecked: Boolean) {

        /*if (button.id == R.id.radio_onibus) {
            binding.inputsCarro.isInvisible = true
            binding.inputsCaminhao.isInvisible = true
            binding.inputsOnibus.isInvisible = false
        }
        if (button.id == R.id.radio_carro) {

            binding.inputsCaminhao.isInvisible = true
            binding.inputsOnibus.isInvisible = true
            binding.inputsCarro.isInvisible = false
        }
        if (button.id == R.id.radio_caminhao) {
            binding.inputsCaminhao.isInvisible = false
            binding.inputsOnibus.isInvisible = true
            binding.inputsCarro.isInvisible = true
        }*/

        when (button.id) {
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

        }

    }

}

