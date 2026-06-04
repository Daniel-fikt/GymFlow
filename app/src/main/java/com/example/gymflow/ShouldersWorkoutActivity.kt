package com.example.gymflow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ShouldersWorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoulders_workout)

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}