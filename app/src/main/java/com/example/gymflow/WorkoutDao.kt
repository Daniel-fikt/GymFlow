package com.example.gymflow

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WorkoutDao {

    @Insert
    fun insert(workout: Workout)

    @Query("SELECT * FROM workouts")
    suspend fun getAll(): List<Workout>
}