package com.example.lifehackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val txtScore = findViewById<TextView>(R.id.txtScore)
        val btnReview = findViewById<Button>(R.id.btnReview)

        val score = intent.getIntExtra("score", 0)

        txtScore.text = "Your Score: $score"

        btnReview.setOnClickListener {
            // TEMPORARY FIX (since ReviewActivity not created yet)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}