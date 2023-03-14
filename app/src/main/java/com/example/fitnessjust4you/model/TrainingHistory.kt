package com.example.fitnessjust4you.model

import java.util.Date

data class TrainingHistory(
    val hid: Int,
    val h_did: Int,
    val h_dweight: Double,
    val h_reps: Int,
    val h_date: Date
)