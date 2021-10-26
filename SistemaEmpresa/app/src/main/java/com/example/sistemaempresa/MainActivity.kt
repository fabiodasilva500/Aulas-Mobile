package com.example.sistemaempresa


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_empresa -> {
                val intent = Intent(this, CadastroEmpresaActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.action_inventario -> {
                val intent = Intent(this, CadastroInventarioActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.action_funcionario -> {
                val intent = Intent(this, CadastroFuncionarioActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_cargos -> {
                val intent = Intent(this, CadastroCargoActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_departamentos -> {
                val intent = Intent(this, CadastroDepartamentoActivity::class.java)
                startActivity(intent)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }


}