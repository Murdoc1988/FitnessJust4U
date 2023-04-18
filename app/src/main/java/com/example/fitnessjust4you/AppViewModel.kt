package com.example.fitnessjust4you

import android.app.Application
import android.graphics.Bitmap
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import com.example.fitnessjust4you.data.FitnessDatabase.Companion.getInstance
import com.example.fitnessjust4you.data.Repository
import com.example.fitnessjust4you.data.entities.*
import kotlinx.coroutines.launch

class AppViewModel(application: Application): AndroidViewModel(application){

    private val database = getInstance(application)
    private val repository = Repository(database)

    val bodyStatsList = repository.bodyStatsList
    val chartList = repository.chartList
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

    fun addChart(chart: Chart){
        viewModelScope.launch {
            repository.addChart(chart)
        }
    }

    fun getChartURL(){
        var url = "https://image-charts.com/chart?cht=lc&chs=700x100"
        var timestamps: String = ""
        var weigts: String = ""
        var fats: String = ""
        var waters: String =""

        repository.bodyStatsList.value!!.forEach {
            timestamps = timestamps + it.btimestamp.toString() + "|"
            weigts = weigts + it.bweigt.toString() + ","
            fats = fats + it.bfat + ","
            waters = waters + it.bwater.toString() +  ","
        }

        url = "$url\$chxl=$timestamps\$chd=$weigts|$fats|waters"
        println(url)

    }
}