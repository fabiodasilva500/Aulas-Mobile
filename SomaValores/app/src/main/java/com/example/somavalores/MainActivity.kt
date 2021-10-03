package com.example.somavalores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btSomar: Button = findViewById(R.id.btsomar)
        btSomar.setOnClickListener {onClickOperation() }

    }

        fun onClickOperation(){
            val txtValor1: EditText = findViewById(R.id.valor1)
            val txtValor2: EditText = findViewById(R.id.valor2)
            val lblResultado: TextView = findViewById(R.id.resultado)

            val valor1:Double = txtValor1.text.toString().toDouble()
            val valor2:Double = txtValor2.text.toString().toDouble()
            val soma:Double = valor1 + valor2


            lblResultado.setText("O resultado da soma é: $soma")
        }

}