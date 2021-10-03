package com.example.numerosimpares

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

    fun onClickOperation(){
        val lblResultado: TextView = findViewById(R.id.resultado)
        lblResultado.setTextColor(Color.BLACK)
        lblResultado.setText(verificaImpares())
    }

    fun verificaImpares(): String{
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
}