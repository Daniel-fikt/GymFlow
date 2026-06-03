package com.example.gymflow

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class WorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        val btnChest = findViewById<Button>(R.id.btnChest)

        btnChest.setOnClickListener {
            Toast.makeText(
                this,
                "Button works",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}