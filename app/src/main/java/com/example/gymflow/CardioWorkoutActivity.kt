package com.example.gymflow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CardioWorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio_workout)

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}