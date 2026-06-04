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

        val profileButton =
            findViewById<TextView>(R.id.btnProfile)

        val membershipButton =
            findViewById<TextView>(R.id.btnMembership)

        val settingsButton =
            findViewById<TextView>(R.id.btnSettings)

        workoutButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    WorkoutActivity::class.java
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

        profileButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ProfileActivity::class.java
                )
            )
        }

        membershipButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MembershipActivity::class.java
                )
            )
        }

        settingsButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SettingsActivity::class.java
                )
            )
        }
    }
}