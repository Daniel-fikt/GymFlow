package com.example.gymflow.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gymflow.UserProfile

@Dao
interface UserProfileDao {

    @Insert
    suspend fun insertProfile(profile: UserProfile)

    @Query("SELECT * FROM user_profile ORDER BY id DESC LIMIT 1")
    suspend fun getLastProfile(): UserProfile?
}