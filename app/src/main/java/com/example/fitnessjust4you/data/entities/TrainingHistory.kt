package com.example.fitnessjust4you.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training_history")
data class TrainingHistory(

    @PrimaryKey(autoGenerate = true)
    val hid: Int,
    val h_did: Int,
    val h_dweight: Double,
    val h_reps: Int,
    val h_date: String
)