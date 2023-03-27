package com.example.fitnessjust4you.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "days")
data class Days(

    @PrimaryKey(autoGenerate = true)
    var did: Int,
    var dname: String
)
