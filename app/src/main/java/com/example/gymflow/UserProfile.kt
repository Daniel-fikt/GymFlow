package com.example.gymflow
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val age: Int,

    val weight: Float,

    val height: Float
)