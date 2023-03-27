package com.example.fitnessjust4you.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "muscle")
data class Muscle(

    @PrimaryKey(autoGenerate = true)
    var mid: Int,
    var mname: String
)
