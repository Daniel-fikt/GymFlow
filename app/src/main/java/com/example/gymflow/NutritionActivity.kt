package com.example.gymflow

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class NutritionActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    private val cameraLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {

                val photo =
                    result.data?.extras?.get("data") as Bitmap

                imageView.setImageBitmap(photo)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition)

        imageView = findViewById(R.id.imgMeal)

        val photoButton =
            findViewById<Button>(R.id.btnTakePhoto)

        val backButton =
            findViewById<Button>(R.id.btnBack)

        photoButton.setOnClickListener {

            val cameraIntent =
                Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            cameraLauncher.launch(cameraIntent)
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}