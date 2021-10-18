package com.example.crudturmas


import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    // No Kotlin, `var` é usado para declarar uma variável mutável. Por outro lado
    // `internal` significa que uma variável é visível dentro de um determinado módulo
    internal var dbHelper = DatabaseHelper(this)

    /**
     * Criando uma função para que seja apresentada uma notificação
     */
    fun showToast(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
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
        setContentView(R.layout.activity_main)

        controlerInicilizaCores()
        controlerInsert()
        controlerUpdate()
        controlerDelete()
        controlerView()
    }

    /**
     * When our handleInserts button is clicked.
     */
    fun controlerInsert() {
        bnEnviar.setOnClickListener {
            try {
                dbHelper.inserirDados(
                    txtNome.text.toString(),
                    txtCurso.text.toString(),
                    txtCampus.text.toString(),
                    txtTurno.text.toString())
                    Toast.makeText(getApplicationContext(), "Inserido com sucesso", Toast.LENGTH_SHORT).show()
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
                val isUpdate = dbHelper.alterarDados(
                    txtID.text.toString(),
                    txtNome.text.toString(),
                    txtCurso.text.toString(),
                    txtCampus.text.toString(),
                    txtTurno.text.toString())


                limpaCampo()
                if (isUpdate == true)
                    Toast.makeText(getApplicationContext(), "Alterado com sucesso", Toast.LENGTH_LONG).show()
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
                dbHelper.deletarDados(txtID.text.toString())
                limpaCampo()
                Toast.makeText(getApplicationContext(), "Excluído com sucesso", Toast.LENGTH_LONG).show()

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


                val res = dbHelper.allData
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

    fun controlerInicilizaCores(){
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
}