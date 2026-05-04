package com.example.lifehackapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val txtReview = findViewById<TextView>(R.id.txtReview)

        txtReview.text = """
            1. Rice does NOT fix water damage
            2. Drinking water improves focus
            3. Cracking knuckles does NOT cause arthritis
        """.trimIndent()
    }
}