package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val txtAge = findViewById<TextView>(R.id.txtAge)
        val txtWeight = findViewById<TextView>(R.id.txtWeight)
        val txtHeight = findViewById<TextView>(R.id.txtHeight)
        val txtBmi = findViewById<TextView>(R.id.txtBmi)

        val editButton = findViewById<Button>(R.id.btnEditProfile)
        val backButton = findViewById<Button>(R.id.btnBack)

        val prefs = getSharedPreferences(
            "GymFlowPrefs",
            MODE_PRIVATE
        )

        val age = prefs.getInt("age", 0)
        val weight = prefs.getFloat("weight", 0f)
        val height = prefs.getFloat("height", 0f)

        val bmi =
            if (height > 0f) {
                weight / ((height / 100f) * (height / 100f))
            } else {
                0f
            }

        txtAge.text = getString(R.string.age_value, age)
        txtWeight.text = getString(R.string.weight_value, weight)
        txtHeight.text = getString(R.string.height_value, height)
        txtBmi.text = getString(R.string.bmi_value, bmi)

        editButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ProfileSetupActivity::class.java
                )
            )
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}