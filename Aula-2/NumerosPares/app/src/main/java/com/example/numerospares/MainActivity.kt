package com.example.numerospares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.graphics.Color


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lblInfo: TextView = findViewById(R.id.lblInfoNumeros)
        lblInfo.setTextColor(Color.BLACK)

        val btnVerificar: Button = findViewById(R.id.btnVerificar)
        btnVerificar.setOnClickListener { onClickOperation() }

    }

    fun onClickOperation() {
        val lblResultado: TextView = findViewById(R.id.resultado)

        lblResultado.setTextColor(Color.BLACK)
        lblResultado.setText(verificaPares())

    }

    fun verificaPares(): String{
       var valor: Int = 1
        var resultado: String = ""
        for (valor in 1..100){
            if(valor % 2 == 0){
                resultado+= valor.toString() + "    "
            }

            //Há cada 10 elementos pulo uma linha
            if(valor%10 == 0){
                resultado+="\n"
            }

            }

            return resultado
    }

    }