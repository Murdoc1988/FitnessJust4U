package com.example.fitnessjust4you.data.entities

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "training_set")
data class TrainingSet(

    @PrimaryKey(autoGenerate = true)
    val sid: Int,
    val sname: String,
    val sdesc: String,
    val ssets: Int,
    val srepsstart: Int,
    val srepsend: Int,
    /*@Embedded
    val spmuscles: Muscle,*/
    val spmuscles: String,
/*    @Embedded
    val ssmuscles: MutableList<Muscle>,*/
    val ssmuscles: String,
    val s_tid: Int,
    val s_uid: Int
): Parcelable