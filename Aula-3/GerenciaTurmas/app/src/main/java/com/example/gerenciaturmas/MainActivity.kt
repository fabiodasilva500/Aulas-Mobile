package com.example.gerenciaturmas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.graphics.Color
import com.example.gerenciaturmas.classes.Turma

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerificar: Button = findViewById(R.id.btnExibir)
        btnVerificar.setOnClickListener { onClickOperation() }
    }

        fun onClickOperation(){
            val txtId: EditText = findViewById(R.id.txtId)
            val txtNome: EditText = findViewById(R.id.txtNome)
            val txtQtdAlunos: EditText = findViewById(R.id.txtQtdAlunos)
            val lblResultado: TextView = findViewById(R.id.resultado)

            lblResultado.setTextColor(Color.BLACK)

            var turma: Turma = Turma()
            turma.setId(txtId.text.toString().toInt())
            turma.setNome(txtNome.text.toString())
            turma.setQtdAlunos(txtQtdAlunos.text.toString().toInt())

            lblResultado.setText("ID da turma: ${turma.getId().toString()} \nNome da turma: ${turma.getNome()} \n" +
                    "Quantidade de alunos: ${turma.getQtdAlunos().toString()}")

            txtId.setText("")
            txtNome.setText("")
            txtQtdAlunos.setText("")
        }


}