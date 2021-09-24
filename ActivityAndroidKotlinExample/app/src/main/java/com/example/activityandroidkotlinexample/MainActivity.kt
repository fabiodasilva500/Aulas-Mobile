package com.example.activityandroidkotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print("Invocando o callback: onCreate")
    }

    override fun onStart() {
        super.onStart()
        print("Invocando o callback: onStart")
    }

    override fun onResume() {
        super.onResume()
        print("Invocando o callback: onResume")
    }


    override fun onPause() {
        super.onPause()
        print("Invocando o callback: onPause")
    }


    override fun onStop() {
        super.onStop()
        print("Invocando o callback: onStop")
    }


    override fun onRestart() {
        super.onRestart()
        print("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        print("onDestroy")
    }

    fun print(msg: String){
        Log.d("Estado da Activity ",msg)
    }


}