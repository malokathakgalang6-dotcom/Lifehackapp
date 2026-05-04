package com.example.lifehackapp

import android.content.Intent
import android.util.Log
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var questions: List<Question>
    private var index = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)

        questions = listOf(
            Question("Putting phone in rice fixes water damage", false, "It does not fully fix it"),
            Question("Drinking water improves focus", true, "Yes, it helps your brain"),
            Question("Cracking knuckles causes arthritis", false, "No scientific proof")
        )

        fun loadQuestion() {
            txtQuestion.text = questions[index].statement
            txtFeedback.text = ""
        }

        fun checkAnswer(userAnswer: Boolean) {
            if (userAnswer == questions[index].isTrue) {
                score++
                txtFeedback.text = "Correct!"
            } else {
                txtFeedback.text = "Wrong!"
            }
        }

        btnTrue.setOnClickListener {
            Log.d("QUIZ", "True button clicked")
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            Log.d("QUIZ", "False button clicked")
            checkAnswer(false)
        }

        btnNext.setOnClickListener {
            Log.d("QUIZ", "Next button clicked")

            index++

            if (index < questions.size) {
                loadQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
        btnNext.setOnClickListener {
            index++
            if (index < questions.size) {
                loadQuestion()
            } else {
                txtQuestion.text = "Quiz Finished! Score: $score"
                txtFeedback.text = ""
            }
        }

        loadQuestion()
    }
}
