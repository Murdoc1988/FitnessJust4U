package com.example.fitnessjust4you.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "weight_history")
data class WeightHistory(

    @PrimaryKey(autoGenerate = true)
    var wid: Double,
    var wdate: Date,
    var w_uid: Int
)
