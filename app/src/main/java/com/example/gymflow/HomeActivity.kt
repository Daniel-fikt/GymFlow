package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.messaging.FirebaseMessaging

class HomeActivity : AppCompatActivity() {

    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        FirebaseMessaging.getInstance().isAutoInitEnabled = true

        FirebaseMessaging.getInstance()
            .subscribeToTopic("gymflow")
            .addOnCompleteListener {

                Toast.makeText(
                    this,
                    "Subscribed to gymflow",
                    Toast.LENGTH_LONG
                ).show()


        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->

                if (!task.isSuccessful) {

                    Toast.makeText(
                        this,
                        "FCM Error: ${task.exception?.message}",
                        Toast.LENGTH_LONG
                    ).show()

                    return@addOnCompleteListener
                }

                val token = task.result

                android.app.AlertDialog.Builder(this)
                    .setTitle("FCM TOKEN")
                    .setMessage(token)
                    .setPositiveButton("OK", null)
                    .show()
            }
    }

                analytics = FirebaseAnalytics.getInstance(this)

                analytics.logEvent("home_opened", null)

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

                    analytics.logEvent("open_workout", null)

                    startActivity(
                        Intent(
                            this,
                            WorkoutActivity::class.java
                        )
                    )
                }

                recommendationsButton.setOnClickListener {

                    analytics.logEvent("open_recommendations", null)

                    startActivity(
                        Intent(
                            this,
                            RecommendationsActivity::class.java
                        )
                    )
                }

                nutritionButton.setOnClickListener {

                    analytics.logEvent("open_nutrition", null)

                    startActivity(
                        Intent(
                            this,
                            NutritionActivity::class.java
                        )
                    )
                }

                profileButton.setOnClickListener {

                    analytics.logEvent("open_profile", null)

                    startActivity(
                        Intent(
                            this,
                            ProfileActivity::class.java
                        )
                    )
                }

                membershipButton.setOnClickListener {

                    analytics.logEvent("open_membership", null)

                    startActivity(
                        Intent(
                            this,
                            MembershipActivity::class.java
                        )
                    )
                }

                settingsButton.setOnClickListener {

                    analytics.logEvent("open_settings", null)

                    startActivity(
                        Intent(
                            this,
                            SettingsActivity::class.java
                        )
                    )
                }
            }
    }