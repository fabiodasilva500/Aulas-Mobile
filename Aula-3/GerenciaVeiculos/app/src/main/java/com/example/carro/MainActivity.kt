package com.example.carro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.*
import android.graphics.Color
import com.example.carro.classes.Carro

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerificar: Button = findViewById(R.id.btnExibir)
        btnVerificar.setOnClickListener { onClickOperation() }
    }

    fun onClickOperation(){
        val txtModelo: EditText = findViewById(R.id.txtModelo)
        val txtAno: EditText = findViewById(R.id.txtAno)
        val txtVelocidade: EditText = findViewById(R.id.txtVelocidade)
        val lblResultado: TextView = findViewById(R.id.resultado)

        lblResultado.setTextColor(Color.BLACK)

        var carro: Carro = Carro()
        carro.setModelo(txtModelo.text.toString())
        carro.setAno(txtAno.text.toString().toInt())
        carro.setVelocidade(txtVelocidade.text.toString().toDouble())

        lblResultado.setText("Modelo do veículo: ${carro.getModelo().toString()} \nAno do veículo: " +
                "${carro.getAno().toInt()} \n" +
                "Velocidade do veículo: ${carro.getVelocidade().toString().toDouble()}")

        txtModelo.setText("")
        txtAno.setText("")
        txtVelocidade.setText("")
    }


}