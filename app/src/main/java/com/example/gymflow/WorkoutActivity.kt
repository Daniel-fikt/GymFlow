package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        findViewById<Button>(R.id.btnChest).setOnClickListener {
            startActivity(Intent(this, ChestWorkoutActivity::class.java))
        }

        findViewById<Button>(R.id.btnArms).setOnClickListener {
            startActivity(Intent(this, ArmsWorkoutActivity::class.java))
        }

        findViewById<Button>(R.id.btnShoulders).setOnClickListener {
            startActivity(Intent(this, ShouldersWorkoutActivity::class.java))
        }

        findViewById<Button>(R.id.btnLegs).setOnClickListener {
            startActivity(Intent(this, LegWorkoutActivity::class.java))
        }

        findViewById<Button>(R.id.btnCardio).setOnClickListener {
            startActivity(Intent(this, CardioWorkoutActivity::class.java))
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}