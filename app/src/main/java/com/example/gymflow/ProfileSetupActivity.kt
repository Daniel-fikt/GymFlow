package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setup)

        val ageEditText = findViewById<EditText>(R.id.etAge)
        val weightEditText = findViewById<EditText>(R.id.etWeight)
        val heightEditText = findViewById<EditText>(R.id.etHeight)

        val saveButton = findViewById<Button>(R.id.btnContinue)

        saveButton.setOnClickListener {

            val age = ageEditText.text.toString()
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()

            if (age.isEmpty() || weight.isEmpty() || height.isEmpty()) {

                Toast.makeText(
                    this,
                    getString(R.string.fill_all_fields),
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val prefs = getSharedPreferences(
                "GymFlowPrefs",
                MODE_PRIVATE
            )

            prefs.edit()
                .putInt("age", age.toInt())
                .putFloat("weight", weight.toFloat())
                .putFloat("height", height.toFloat())
                .apply()

            Toast.makeText(
                this,
                getString(R.string.profile_saved),
                Toast.LENGTH_SHORT
            ).show()

            startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )

            finish()
        }
    }
}