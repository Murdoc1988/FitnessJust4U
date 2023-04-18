package com.example.fitnessjust4you.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bodystats")
data class BodyStats(

    @PrimaryKey(autoGenerate = true)
    val bid: Int,
    var btimestamp: String,
    var bweigt: Double,
    var bfat: Double,
    var bwater: Double,
    var bs_uid: Int
)
