package com.example.fitnessjust4you.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    var uid: Int,
    var uname: String,
    var ufname: String,
    var ulname: String,
    var umail: String,
    var upass: String,
    var uregdate: Long = System.currentTimeMillis(),
    var uweight: Double,
    var usize: Double,
    var usex: String,
/*    @Embedded
    var uweightdays: MutableList<Days>,*/
    var uweightdays: String,
    var uweightinterval: Int
)
