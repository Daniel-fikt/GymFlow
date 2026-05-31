package com.example.gymflow

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class WorkoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "Workout opened", Toast.LENGTH_SHORT).show()

        setContentView(R.layout.activity_workout)
    }
}