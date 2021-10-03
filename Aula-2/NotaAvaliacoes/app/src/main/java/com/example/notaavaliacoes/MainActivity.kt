package com.example.notaavaliacoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btSomar: Button = findViewById(R.id.btnCalcularMedia)
        val txtExame: EditText = findViewById(R.id.txtNotaExame)
        btSomar.setOnClickListener {onClickOperation(txtExame) }

    }

    fun onClickOperation(txtExame:EditText){
        val txtNota1: EditText = findViewById(R.id.txtNota1)
        val txtNota2: EditText = findViewById(R.id.txtNota2)


        val lblResultado: TextView = findViewById(R.id.lblResultado)

        val nota1:Double = txtNota1.text.toString().toDouble()
        val nota2:Double = txtNota2.text.toString().toDouble()

        var media = (nota1 + nota2) /2

        if(media<=6) {

            if (!txtExame.isEnabled) {
                txtExame.setEnabled(true)
                txtExame.setText("0.0")
            }

            val notaExame = txtExame.text.toString().toDouble()

            if(notaExame>0.0){
                media = (media + notaExame) / 2
            }

            if (media >= 6 && notaExame > 0.0) {
                lblResultado.setText("Aprovado: $media")
                lblResultado.setTextColor(Color.BLUE)
                txtExame.setEnabled(false)
            } else
                if (media < 6 && notaExame == 0.0) {
                    lblResultado.setText("Reprovado: $media")
                    lblResultado.setTextColor(Color.RED)
                }
                else {
                    lblResultado.setText("Reprovado: $media")
                    lblResultado.setTextColor(Color.RED)
                    txtExame.setEnabled(false)
                }
        }

        else{
            lblResultado.setText("Aprovado: $media")
            lblResultado.setTextColor(Color.BLUE)
            txtExame.setEnabled(false)
        }

    }

}