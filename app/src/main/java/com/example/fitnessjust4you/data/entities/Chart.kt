package com.example.fitnessjust4you.data.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "charts")
data class Chart(

    @PrimaryKey
    var cid: Int,
    var ctype: String,
    var chart: Bitmap,
    var c_uid: Int,
)
