package com.example.fitnessjust4you.model

data class User(
    var uid: Int,
    var uname: String,
    var ufname: String,
    var ulname: String,
    var umail: String,
    var upass: String,
    var uweight: Double,
    var usize: Double,
    var uweightdays: MutableList<Days>,
    var uweightinterval: Int
)
