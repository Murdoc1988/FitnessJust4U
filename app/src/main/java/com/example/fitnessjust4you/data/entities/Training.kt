package com.example.fitnessjust4you.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "training")
data class Training(

    @PrimaryKey(autoGenerate = true)
    val tid: Int,
    val tname: String,
    val tdate: Long = System.currentTimeMillis()
    ): Parcelable
