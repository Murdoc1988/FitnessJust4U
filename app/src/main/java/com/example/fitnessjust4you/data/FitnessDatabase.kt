package com.example.fitnessjust4you.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fitnessjust4you.data.entities.*


@Database(
    entities = [
        Muscle::class,
        Training::class,
        TrainingDetail::class,
        TrainingHistory::class,
        TrainingSet::class,
        User::class,
        Days::class,
        BodyStats::class,
        Chart::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class FitnessDatabase: RoomDatabase() {

    abstract val fitnessDao:FitnessDao

    companion object{
        @Volatile
        private var INSTANCE: FitnessDatabase? = null

        fun getInstance(context: Context): FitnessDatabase{

            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                FitnessDatabase::class.java,
                "fitness_db"
                ).build().also {
                    INSTANCE = it
            }
            }
        }
    }

}