package com.example.fitnessjust4you.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training_set")
data class TrainingSet(

    @PrimaryKey(autoGenerate = true)
    val sid: Int,
    val sname: String,
    val sdesc: String,
    val spmuscles: Muscle,
    val ssmuscles: MutableList<Muscle>,
    val s_tid: Int,
    val s_uid: Int
)