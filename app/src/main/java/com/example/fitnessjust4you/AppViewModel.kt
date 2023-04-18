package com.example.fitnessjust4you

import android.app.Application
import android.graphics.Bitmap
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import com.example.fitnessjust4you.data.FitnessDatabase.Companion.getInstance
import com.example.fitnessjust4you.data.Repository
import com.example.fitnessjust4you.data.entities.BodyStats
import com.example.fitnessjust4you.data.entities.Training
import com.example.fitnessjust4you.data.entities.TrainingDetail
import com.example.fitnessjust4you.data.entities.TrainingSet
import kotlinx.coroutines.launch

class AppViewModel(application: Application): AndroidViewModel(application){

    private val database = getInstance(application)
    private val repository = Repository(database)

    val bodyStatsList = repository.bodyStatsList
    val trainingList = repository.trainingList
    val setList = repository.setList
    val detailList = repository.detailList


    fun addBodyStats(bodyStats: BodyStats){
        viewModelScope.launch {
            repository.addBodyStats(bodyStats)
        }
    }

    fun addTraining(training: Training){
        viewModelScope.launch {
            repository.addTraining(training)
        }
    }

    fun addSet(set: TrainingSet){
        viewModelScope.launch {
            repository.addSet(set)
        }
    }

    fun addDetail(trainingDetail: TrainingDetail){
        viewModelScope.launch {
            repository.addDetail(trainingDetail)
        }
    }
}