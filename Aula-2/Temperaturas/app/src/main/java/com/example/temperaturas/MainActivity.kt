package com.example.temperaturas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btSomar: Button = findViewById(R.id.btnVerificar)
        btSomar.setOnClickListener { onClickOperation() }

    }

    fun onClickOperation() {
        val txtTemperatura1: EditText = findViewById(R.id.txtTemperatura1)
        val txtTemperatura2: EditText = findViewById(R.id.txtTemperatura2)
        val txtTemperatura3: EditText = findViewById(R.id.txtTemperatura3)

        val lblResultado: TextView = findViewById(R.id.lblResultado)

        val temperatura1: Double = txtTemperatura1.text.toString().toDouble()
        val temperatura2: Double = txtTemperatura2.text.toString().toDouble()
        val temperatura3: Double = txtTemperatura2.text.toString().toDouble()

        lblResultado.setText(verificaTemperatura(temperatura1, temperatura2, temperatura3))
    }

    fun verificaTemperatura(
        temperatura1: Double,
        temperatura2: Double,
        temperatura3: Double
    ): String {
        if (temperatura1 < 0 || temperatura2 < 0 || temperatura3 < 0)
            return "Foi informada uma ou mais temperaturas negativas"
        else
            return "Não foram informadas temperaturas negativas"

    }
}