package com.example.fitnessjust4you.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training")
data class Training(

    @PrimaryKey(autoGenerate = true)
    val tid: Int,
    val tname: String,
    val tdate: String
    )
