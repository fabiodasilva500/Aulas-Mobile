package com.example.notasprovageral

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerificar: Button = findViewById(R.id.btnVerificar)
        btnVerificar.setOnClickListener { onClickOperation() }
    }

    fun onClickOperation() {
        val txtNotaProfessor: EditText = findViewById(R.id.txtNotaProfessor)
        val txtNotaGeral: EditText = findViewById(R.id.txtNotaGeral)
        val lblResultado: TextView = findViewById(R.id.lblResultado)

        val notaProfessor: Double = txtNotaProfessor.text.toString().toDouble()
        val notaGeral: Double = txtNotaGeral.text.toString().toDouble()

        lblResultado.setTextColor(Color.BLACK)

        if (notaProfessor > 6 || notaGeral > 6)
            lblResultado.setText("Uma das notas informadas é maior do que 6")
        else
            lblResultado.setText("Nenhuma das notas informadas é maior do que 6")
    }

}