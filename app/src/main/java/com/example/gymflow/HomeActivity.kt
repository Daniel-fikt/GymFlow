package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val workoutButton =
            findViewById<TextView>(R.id.btnWorkout)

        val recommendationsButton =
            findViewById<TextView>(R.id.btnRecommendations)

        val nutritionButton =
            findViewById<TextView>(R.id.btnNutrition)

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

        nutritionButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    NutritionActivity::class.java
                )
            )
        }
    }
}