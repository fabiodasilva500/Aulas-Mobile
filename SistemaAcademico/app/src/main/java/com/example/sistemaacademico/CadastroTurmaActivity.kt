package com.example.sistemaacademico

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastro_turma.*
import com.example.sistemaacademico.persistencia.TurmaDao
import kotlinx.android.synthetic.main.activity_cadastro_disciplina.*
import kotlinx.android.synthetic.main.activity_cadastro_turma.bnAtualizar
import kotlinx.android.synthetic.main.activity_cadastro_turma.bnConsultar
import kotlinx.android.synthetic.main.activity_cadastro_turma.bnEnviar
import kotlinx.android.synthetic.main.activity_cadastro_turma.bnExcluir
import kotlinx.android.synthetic.main.activity_cadastro_turma.bnVoltar
import kotlinx.android.synthetic.main.activity_cadastro_turma.lblCurso
import kotlinx.android.synthetic.main.activity_cadastro_turma.lblInfoID
import kotlinx.android.synthetic.main.activity_cadastro_turma.lblInfoNome
import kotlinx.android.synthetic.main.activity_cadastro_turma.lblTurno
import kotlinx.android.synthetic.main.activity_cadastro_turma.txtCurso
import kotlinx.android.synthetic.main.activity_cadastro_turma.txtID
import kotlinx.android.synthetic.main.activity_cadastro_turma.txtNome
import kotlinx.android.synthetic.main.activity_cadastro_turma.txtTurno


class CadastroTurmaActivity : AppCompatActivity() {

    // No Kotlin, `var` é usado para declarar uma variável mutável. Por outro lado
    // `internal` significa que uma variável é visível dentro de um determinado módulo
    internal var dbHelperTurma = TurmaDao(this)

    /**
     * Criando uma função para que seja apresentada uma notificação
     */
    fun showToast(text: String) {
        Toast.makeText(this@CadastroTurmaActivity, text, Toast.LENGTH_LONG).show()
    }

    /**
     * Vamos criar uma função para mostrar uma caixa de diálogo de alerta com a caixa de diálogo de dados.
     */

    fun showDialog(title: String, Message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    /**
     * Criando um método para limpar os componentes de tela
     */
    fun limpaCampo() {
        txtID.setText("")
        txtNome.setText("")
        txtCurso.setText("")
        txtCampus.setText("")
        txtTurno.setText("")
    }

    /**
     * Sobrescrevendo o método onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_turma)

        controlerInicilizaCores()
        controlerInsert()
        controlerUpdate()
        controlerDelete()
        controlerView()
        controllerReturn()
    }

    /**
     * When our handleInserts button is clicked.
     */
    fun controlerInsert() {
        bnEnviar.setOnClickListener {
            try {
                dbHelperTurma.inserirDados(
                    txtNome.text.toString(),
                    txtCurso.text.toString(),
                    txtCampus.text.toString(),
                    txtTurno.text.toString()
                )
                Toast.makeText(getApplicationContext(), "Inserido com sucesso", Toast.LENGTH_SHORT)
                    .show()
                limpaCampo()
            } catch (e: Exception) {
                e.printStackTrace()
                showToast(e.message.toString())
            }

        }
    }

    /**
     * Acionando para requisitar a alteração do cadastro
     */
    fun controlerUpdate() {
        bnAtualizar.setOnClickListener {
            try {
                val isUpdate = dbHelperTurma.alterarDados(
                    txtID.text.toString(),
                    txtNome.text.toString(),
                    txtCurso.text.toString(),
                    txtCampus.text.toString(),
                    txtTurno.text.toString()
                )


                limpaCampo()
                if (isUpdate == true)
                    Toast.makeText(
                        getApplicationContext(),
                        "Alterado com sucesso",
                        Toast.LENGTH_LONG
                    ).show()
                else
                    showToast("Data Not Updated")
            } catch (e: Exception) {
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    /**
     * Acionando para requisitar a excluir do cadastro
     */
    fun controlerDelete() {
        bnExcluir.setOnClickListener {
            try {
                dbHelperTurma.deletarDados(txtID.text.toString())
                limpaCampo()
                Toast.makeText(getApplicationContext(), "Excluído com sucesso", Toast.LENGTH_LONG)
                    .show()

            } catch (e: Exception) {
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    /**
     * View para apresentação dos dados
     */
    fun controlerView() {
        bnConsultar.setOnClickListener(
            View.OnClickListener {


                val res = dbHelperTurma.allData
                if (res.count == 0) {
                    showDialog("Erro", "Dados não encontratos")
                    return@OnClickListener
                }


                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID:" + res.getString(0))
                    buffer.append(", Nome:" + res.getString(1))
                    buffer.append(", Curso:" + res.getString(2))
                    buffer.append(", Campus:" + res.getString(3))
                    buffer.append(", Turno:" + res.getString(4))

                    buffer.append("\n")
                }
                showDialog("Dados retornados", buffer.toString())
            }
        )
    }

    fun controlerInicilizaCores() {
        lblInfoID.setTextColor(Color.BLACK)
        txtID.setTextColor(Color.BLACK)

        lblInfoNome.setTextColor(Color.BLACK)
        txtNome.setTextColor(Color.BLACK)

        lblCurso.setTextColor(Color.BLACK)
        txtCurso.setTextColor(Color.BLACK)

        lblCurso.setTextColor(Color.BLACK)
        txtCurso.setTextColor(Color.BLACK)

        lblCampus.setTextColor(Color.BLACK)
        txtCampus.setTextColor(Color.BLACK)

        lblTurno.setTextColor(Color.BLACK)
        txtTurno.setTextColor(Color.BLACK)
    }


    fun controllerReturn() {
        bnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}