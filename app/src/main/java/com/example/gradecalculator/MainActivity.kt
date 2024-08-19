package com.example.gradecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextMarks = findViewById<EditText>(R.id.editTextMarks)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewGrade = findViewById<TextView>(R.id.textViewGrade)
        val textViewMessage = findViewById<TextView>(R.id.textViewMessage)

        buttonCalculate.setOnClickListener {
            val marks = editTextMarks.text.toString().toDoubleOrNull()
            if (marks != null) {
                val grade = calculateGrade(marks)
                textViewGrade.text = "Grade: $grade"
                textViewMessage.text = getGreetingMessage(grade)
            } else {
                textViewGrade.text = "Grade: N/A"
                textViewMessage.text = "Please enter valid marks."
            }
        }
    }

    private fun calculateGrade(marks: Double): String {
        return when {
            marks >= 75 -> "A"
            marks >= 65 -> "B"
            marks >= 54 -> "C"
            marks >= 35 -> "S"
            else -> "F"
        }
    }

    private fun getGreetingMessage(grade: String): String {
        return when (grade) {
            "A" -> "Excellent! Keep up the good work!"
            "B" -> "Well done!"
            "C" -> "Good job!"
            "S" -> "You can do better!"
            else -> "Work harder to improve!"
        }
    }
}