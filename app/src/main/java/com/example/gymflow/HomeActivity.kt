package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val workoutButton = findViewById<Button>(R.id.btnWorkout)

        workoutButton.setOnClickListener {
            startActivity(Intent(this, WorkoutActivity::class.java))
        }
    }
}