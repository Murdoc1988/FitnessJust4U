package com.example.fitnessjust4you.model

data class TrainingSet(
    val sid: Int,
    val sname: String,
    val sdesc: String,
    val spmuscles: Muscle,
    val ssmuscles: MutableList<Muscle>,
    val s_tid: Int,
    val s_uid: Int
)