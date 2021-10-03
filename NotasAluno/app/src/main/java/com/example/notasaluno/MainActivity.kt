package com.example.notasaluno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener { onClickOperation() }

    }

    fun onClickOperation() {
        val txtNota1: EditText = findViewById(R.id.nota1)
        val txtNota2: EditText = findViewById(R.id.nota2)
        val txtNota3: EditText = findViewById(R.id.nota3)
        val txtNota4: EditText = findViewById(R.id.nota4)


        val nota1: Double = txtNota1.text.toString().toDouble()
        val nota2: Double = txtNota2.text.toString().toDouble()
        val nota3: Double = txtNota3.text.toString().toDouble()
        val nota4: Double = txtNota4.text.toString().toDouble()

        val lblResultado: TextView = findViewById(R.id.resultado)
        lblResultado.setTextColor(Color.BLACK)
        lblResultado.setText(calculaResultado(nota1, nota2, nota3, nota4))

    }


    fun calculaResultado(nota1: Double, nota2: Double, nota3: Double, nota4: Double): String {
        var resultado = ""
        val media = (nota1 + nota2 + nota3 + nota4) / 4

        if (media >= 6) {
            resultado = "Aprovado: $media"
        } else
            if (media >= 3 && media < 6) {
                resultado = "Exame: $media"
            } else {
                resultado = "Reprovado: $media"
            }

        return resultado
    }
}
