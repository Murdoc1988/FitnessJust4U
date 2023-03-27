package com.example.fitnessjust4you.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "training_detail")
data class TrainingDetail(

    @PrimaryKey(autoGenerate = true)
    val did: Int,
    val dset: Int,
    val dweight: Double,
    val dreps: Int,
    val dbreakmin: Int,
    val dbreaktsec: Int,
    val d_sid: Int
)
