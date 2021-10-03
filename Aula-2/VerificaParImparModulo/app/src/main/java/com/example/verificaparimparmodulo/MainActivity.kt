package com.example.verificaparimparmodulo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onRadioButtonSelected(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked
            val lblInfo: TextView = findViewById(R.id.resultado)
            lblInfo.setTextColor(Color.BLACK)

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rdbPares ->
                    if (checked) {
                        lblInfo.setText(exibePares())
                    }
                R.id.rdbImpares ->
                    if (checked) {
                        lblInfo.setText(exibeImpares())
                    }

                R.id.rdbDivisiveis ->
                    if (checked) {
                        lblInfo.setText(exibeDivisiveis())
                    }
            }
        }
    }


    fun exibePares(): String {
        var valor: Int = 1
        var resultado: String = ""
        for (valor in 1..100) {
            if (valor % 2 == 0) {
                resultado += valor.toString() + "    "
            }

            //Há cada 10 elementos pulo uma linha
            if (valor % 10 == 0) {
                resultado += "\n"
            }

        }

        return resultado
    }


    fun exibeImpares(): String {
        var valor: Int = 1
        var resultado: String = ""
        while (valor<100){
            if(valor % 2 == 1){
                resultado+= valor.toString() + "    "
            }

            //Há cada 10 elementos pulo uma linha
            if(valor%10 == 0){
                resultado+="\n"
            }

            valor = valor + 1
        }

        return resultado
    }


    fun exibeDivisiveis(): String {
        var valor: Int = 1
        var resultado: String = ""
        while (valor<=100){
            if(valor % 5 == 0){
                resultado+= valor.toString() + "    "
            }

            //Há cada 10 elementos pulo uma linha
            if(valor%10 == 0){
                resultado+="\n"
            }

            valor = valor + 1
        }

        return resultado
    }

    }
