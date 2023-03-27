package com.example.fitnessjust4you.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weight_history")
data class WeightHistory(

    @PrimaryKey(autoGenerate = true)
    var wid: Int,
    var wdate: Long = System.currentTimeMillis(),
    var w_uid: Int
)
