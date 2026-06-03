package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setup)

        val continueButton = findViewById<Button>(R.id.btnContinue)

        continueButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    WorkoutActivity::class.java
                )
            )
            finish()
        }
    }
}