package com.example.gymflow

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecommendationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendations)

        val bmiText = findViewById<TextView>(R.id.txtBmi)
        val caloriesText = findViewById<TextView>(R.id.txtCalories)
        val waterText = findViewById<TextView>(R.id.txtWater)
        val workoutsText = findViewById<TextView>(R.id.txtWorkouts)
        val backButton = findViewById<Button>(R.id.btnBack)

        val prefs = getSharedPreferences(
            "GymFlowPrefs",
            MODE_PRIVATE
        )

        val weight = prefs.getFloat("weight", 70f)
        val height = prefs.getFloat("height", 170f)

        val heightMeters = height / 100f

        val bmi = weight / (heightMeters * heightMeters)

        val calories = (weight * 33).toInt()

        val water = String.format("%.1f", weight * 0.035f)

        val workouts =
            when {
                bmi < 18.5 -> 3
                bmi < 25 -> 4
                bmi < 30 -> 5
                else -> 5
            }

        bmiText.text = "📊 BMI: %.1f".format(bmi)

        caloriesText.text =
            "🔥 Препорачани калории: $calories kcal"

        waterText.text =
            "💧 Препорачана вода: $water L"

        workoutsText.text =
            "🏋️ Препорачани тренинзи: $workouts неделно"

        backButton.setOnClickListener {
            finish()
        }
    }
}