package com.example.fitnessjust4you.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training_set")
data class TrainingSet(

    @PrimaryKey(autoGenerate = true)
    val sid: Int,
    val sname: String,
    val sdesc: String,
    /*@Embedded
    val spmuscles: Muscle,*/
    val spmuscles: String,
/*    @Embedded
    val ssmuscles: MutableList<Muscle>,*/
    val ssmuscles: String,
    val s_tid: Int,
    val s_uid: Int
)