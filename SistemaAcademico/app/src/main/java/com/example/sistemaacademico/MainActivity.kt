package com.example.sistemaacademico


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro_curso.*

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
            R.id.action_campus -> {
                val intent = Intent(this, CadastroCampusActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_cursos -> {
                val intent = Intent(this, CadastroCursoActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_alunos -> {
                val intent = Intent(this, CadastroAlunosActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_turmas -> {
                val intent = Intent(this, CadastroTurmaActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.action_disciplinas -> {
                val intent = Intent(this, CadastroDisciplinaActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}