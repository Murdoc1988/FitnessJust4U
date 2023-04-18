package com.example.fitnessjust4you.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitnessjust4you.data.entities.*

@Dao
interface FitnessDao {


    //INSERTS

    //Muscle
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMuscle(muscle: Muscle)

    //Training
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTraining(training: Training)

    //TrainingDetail
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingDetail(trainingDetail: TrainingDetail)

    //TrainingHistory
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingHistory(trainingHistory: TrainingHistory)

    //TrainingSet
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingSet(trainingSet: TrainingSet)

    //BodyStats
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBodyStats(bodyStats: BodyStats)



    //SELECT ALL

    //Muscle
    @Query("SELECT * FROM muscle")
    fun getMuscles():LiveData<List<Muscle>>

    //Training
    @Query("SELECT * FROM training")
    fun getTrainings():LiveData<List<Training>>

    //TrainingDetail
    @Query("SELECT * FROM training_detail")
    fun getTrainingDetails():LiveData<List<TrainingDetail>>

    //TrainingHistory
    @Query("SELECT * FROM training_detail")
    fun getTrainingHistory():LiveData<List<TrainingDetail>>

    //TrainingSet
    @Query("SELECT * FROM training_set")
    fun getTrainingsSets():LiveData<List<TrainingSet>>

    //User
    @Query("SELECT * FROM user")
    fun getUsers():LiveData<List<User>>

    //BodyStats
    @Query("SELECT * FROM bodystats")
    fun getBodyStats():LiveData<List<BodyStats>>




}