package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar

        actionBar!!.title = "Menu em Kotlin"
        actionBar.subtitle = "Criando o primeiro menu"
        actionBar.elevation = 4.0F
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
            R.id.action_recortar -> {
                text_view.text = "Recortar"
                return true
            }
            R.id.action_copiar -> {
                text_view.text = "Copiar"
                return true
            }
            R.id.action_colar -> {
                text_view.text = "Colar"
                return true
            }
            R.id.action_novo -> {
                text_view.text = "Novo"
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}