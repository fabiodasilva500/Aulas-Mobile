package com.example.sistemaempresa


import android.app.AlertDialog
import android.view.View
import android.widget.Toast
import android.content.Intent
import kotlinx.android.synthetic.main.activity_cadastro_empresa.*
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sistemaempresa.persistencia.EmpresaDao
import kotlinx.android.synthetic.main.activity_main.*

class CadastroEmpresaActivity : AppCompatActivity() {

    // No Kotlin, `var` é usado para declarar uma variável mutável. Por outro lado
    // `internal` significa que uma variável é visível dentro de um determinado módulo
    internal var dbHelperEmpresa = EmpresaDao(this)


    /**
     * Criando uma função para que seja apresentada uma notificação
     */
    fun showToast(text: String) {
        Toast.makeText(this@CadastroEmpresaActivity, text, Toast.LENGTH_LONG).show()
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
        txtDescricao.setText("")
        txtEndereco.setText("")
        txtFinalidade.setText("")
        txtQtdAndares.setText("")
    }

    /**
     * Sobrescrevendo o método onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_empresa)

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
                dbHelperEmpresa.inserirDados(
                    txtNome.text.toString(),
                    txtDescricao.text.toString(),
                    txtEndereco.text.toString(),
                    txtFinalidade.text.toString(),
                    txtQtdAndares.text.toString())
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
                val isUpdate = dbHelperEmpresa.alterarDados(
                    txtID.text.toString(),
                    txtNome.text.toString(),
                    txtDescricao.text.toString(),
                    txtEndereco.text.toString(),
                    txtFinalidade.text.toString(),
                    txtQtdAndares.text.toString())

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
                dbHelperEmpresa.deletarDados(txtID.text.toString())
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


                val res = dbHelperEmpresa.allData
                if (res.count == 0) {
                    showDialog("Erro", "Dados não encontratos")
                    return@OnClickListener
                }


                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID:" + res.getString(0))
                    buffer.append(", Nome:" + res.getString(1))
                    buffer.append(", Descrição:" + res.getString(2))
                    buffer.append(", Endereço:" + res.getString(3))
                    buffer.append(", Finalidade:" + res.getString(4))
                    buffer.append(", Quantidade de andares:" + res.getString(5))


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

        lblDescricao.setTextColor(Color.BLACK)
        txtDescricao.setTextColor(Color.BLACK)

        lblEndereco.setTextColor(Color.BLACK)
        txtEndereco.setTextColor(Color.BLACK)

        lblFinalidade.setTextColor(Color.BLACK)
        txtFinalidade.setTextColor(Color.BLACK)

        lblQtdAndares.setTextColor(Color.BLACK)
        txtQtdAndares.setTextColor(Color.BLACK)
    }


    fun controllerReturn() {
        bnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}