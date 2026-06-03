package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val workoutButton =
            findViewById<android.widget.TextView>(R.id.btnWorkout)

        val recommendationsButton =
            findViewById<android.widget.TextView>(R.id.btnRecommendations)

        workoutButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ProfileSetupActivity::class.java
                )
            )
        }

        recommendationsButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    RecommendationsActivity::class.java
                )
            )
        }
    }
}