package com.example.lifehackapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.btnStart)

        startButton.setOnClickListener {
            Log.d("MainActivity", "Start clicked")

            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}