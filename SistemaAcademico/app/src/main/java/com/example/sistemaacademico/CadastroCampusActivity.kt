package com.example.sistemaacademico


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastro_campus.*
import android.graphics.Color
import com.example.sistemaacademico.persistencia.CampusDao
import com.example.sistemaacademico.persistencia.CursoDao
import kotlinx.android.synthetic.main.activity_cadastro_alunos.*
import kotlinx.android.synthetic.main.activity_cadastro_campus.bnAtualizar
import kotlinx.android.synthetic.main.activity_cadastro_campus.bnConsultar
import kotlinx.android.synthetic.main.activity_cadastro_campus.bnEnviar
import kotlinx.android.synthetic.main.activity_cadastro_campus.bnExcluir
import kotlinx.android.synthetic.main.activity_cadastro_campus.bnVoltar
import kotlinx.android.synthetic.main.activity_cadastro_campus.lblEndereco
import kotlinx.android.synthetic.main.activity_cadastro_campus.lblInfoID
import kotlinx.android.synthetic.main.activity_cadastro_campus.lblInfoNome
import kotlinx.android.synthetic.main.activity_cadastro_campus.txtEndereco
import kotlinx.android.synthetic.main.activity_cadastro_campus.txtID
import kotlinx.android.synthetic.main.activity_cadastro_campus.txtNome

class CadastroCampusActivity : AppCompatActivity() {

    // No Kotlin, `var` é usado para declarar uma variável mutável. Por outro lado
    // `internal` significa que uma variável é visível dentro de um determinado módulo
    internal var dbHelperCampus = CampusDao(this)

    /**
     * Criando uma função para que seja apresentada uma notificação
     */
    fun showToast(text: String) {
        Toast.makeText(this@CadastroCampusActivity, text, Toast.LENGTH_LONG).show()
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
        txtEndereco.setText("")
        txtCapacidade.setText("")
        txtPontoReferencia.setText("")
        txtTurnos.setText("")
    }

    /**
     * Sobrescrevendo o método onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_campus)

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
                dbHelperCampus.inserirDados(
                    txtNome.text.toString(),
                    txtEndereco.text.toString(),
                    txtCapacidade.text.toString(),
                    txtPontoReferencia.text.toString(),
                    txtTurnos.text.toString()
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
                val isUpdate = dbHelperCampus.alterarDados(
                    txtID.text.toString(),
                    txtNome.text.toString(),
                    txtEndereco.text.toString(),
                    txtCapacidade.text.toString(),
                    txtPontoReferencia.text.toString(),
                    txtTurnos.text.toString()
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
                dbHelperCampus.deletarDados(txtID.text.toString())
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


                val res = dbHelperCampus.allData
                if (res.count == 0) {
                    showDialog("Erro", "Dados não encontratos")
                    return@OnClickListener
                }


                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID:" + res.getString(0))
                    buffer.append(", Nome:" + res.getString(1))
                    buffer.append(", Endereço:" + res.getString(2))
                    buffer.append(", Capacidade:" + res.getString(3))
                    buffer.append(", Ponto de referência:" + res.getString(4))
                    buffer.append(", Turnos:" + res.getString(5))


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

        lblEndereco.setTextColor(Color.BLACK)
        txtEndereco.setTextColor(Color.BLACK)

        lblCapacidade.setTextColor(Color.BLACK)
        txtCapacidade.setTextColor(Color.BLACK)

        lblPontoReferencia.setTextColor(Color.BLACK)
        txtPontoReferencia.setTextColor(Color.BLACK)

        lblTurnos.setTextColor(Color.BLACK)
        txtTurnos.setTextColor(Color.BLACK)
    }

    fun controllerReturn() {
        bnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}