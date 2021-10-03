package com.example.calculoimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular:Button = findViewById(R.id.btCalcular)
        btCalcular.setOnClickListener {onClickOperation() }

    }

    fun onClickOperation(){
        val txtPeso: EditText = findViewById(R.id.peso)
        val txtAltura: EditText = findViewById(R.id.altura)
        val lblResultado: TextView = findViewById(R.id.resultado)

        val peso:Double = txtPeso.text.toString().toDouble()
        val altura:Double = txtAltura.text.toString().toDouble()
        val imc:Double = peso / (altura * altura);

        if(imc<19){
            lblResultado.setTextColor(Color.RED)
            lblResultado.setText("O seu IMC é: $imc e você está abaixo do peso")
        }
        else if (imc>32){
            lblResultado.setTextColor(Color.RED)
            lblResultado.setText("O seu IMC é: $imc e você está acima do peso")
        }
        else{
            lblResultado.setTextColor(Color.BLUE)
            lblResultado.setText("O seu IMC é: $imc e você está dentro do peso")
        }

    }


}