package com.example.fitnessjust4you.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.fitnessjust4you.data.entities.BodyStats
import com.example.fitnessjust4you.data.entities.Training
import com.example.fitnessjust4you.data.entities.TrainingDetail
import com.example.fitnessjust4you.data.entities.TrainingSet

data class Repository(private val fitnessDatabase: FitnessDatabase){

    //getter
    //List of Trainings
    val trainingList: LiveData<List<Training>> get() = fitnessDatabase.fitnessDao.getTrainings()

    //List  of Sets
    val setList: LiveData<List<TrainingSet>> get() = fitnessDatabase.fitnessDao.getTrainingsSets()

    //List of Details
    val detailList: LiveData<List<TrainingDetail>> get() = fitnessDatabase.fitnessDao.getTrainingDetails()

    //List of BodyStats
    val bodyStatsList: LiveData<List<BodyStats>> get() = fitnessDatabase.fitnessDao.getBodyStats()


    //insert/add

    //add Trainings
    suspend fun addTraining(training: Training){
        try {
            fitnessDatabase.fitnessDao.insertTraining(training)
        }catch(e: java.lang.Exception){
            Log.e("Repository", "Failed to insert ${training.tname} into FitnessDatabase: $e")
        }
    }

    suspend fun addSet(trainingSet: TrainingSet){
        try {
            fitnessDatabase.fitnessDao.insertTrainingSet(trainingSet)
        }catch(e: Exception){
            Log.e("Repository", "Failed to insert ${trainingSet.sname} into FitnessDatabase")
        }
    }

    suspend fun addDetail(trainingDetail: TrainingDetail){
        try {
            fitnessDatabase.fitnessDao.insertTrainingDetail(trainingDetail)
        }catch (e: Exception){
            Log.e("Repository", "Failed to insert ${trainingDetail.did} into FitnessDatabase")
        }
    }

    suspend fun addBodyStats(bodyStats: BodyStats){
        try {
            fitnessDatabase.fitnessDao.insertBodyStats(bodyStats)
        }catch (e: Exception){
            Log.e("Repository", "Failed to inserts Bodystats in to FitnessDatabase")
        }
    }

}
