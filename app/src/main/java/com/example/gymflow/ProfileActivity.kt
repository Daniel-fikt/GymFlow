package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.gymflow.data.local.AppDatabase
import kotlinx.coroutines.launch

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

        lifecycleScope.launch {

            val profile = AppDatabase
                .getDatabase(this@ProfileActivity)
                .userProfileDao()
                .getLastProfile()

            profile?.let {

                val bmi =
                    if (it.height > 0f) {
                        it.weight / ((it.height / 100f) * (it.height / 100f))
                    } else {
                        0f
                    }

                txtAge.text = getString(
                    R.string.age_value,
                    it.age
                )

                txtWeight.text = getString(
                    R.string.weight_value,
                    it.weight
                )

                txtHeight.text = getString(
                    R.string.height_value,
                    it.height
                )

                txtBmi.text = getString(
                    R.string.bmi_value,
                    bmi
                )
            }
        }

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