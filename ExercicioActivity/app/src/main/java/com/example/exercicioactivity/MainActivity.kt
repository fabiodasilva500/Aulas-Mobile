package com.example.exercicioactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}