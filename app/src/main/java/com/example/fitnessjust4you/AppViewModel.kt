package com.example.fitnessjust4you

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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


    private val _currentTraining = MutableLiveData<Training>()
    val currentTraining: LiveData<Training>
        get() = _currentTraining

    private val _currentSet = MutableLiveData<TrainingSet>()
    val currentSet: LiveData<TrainingSet>
        get() = _currentSet

    private val _currentSetList = MutableLiveData<List<TrainingSet>>()
    val currentSetList: LiveData<List<TrainingSet>>
        get() = _currentSetList

    fun setCurrentSet(trainingSet: TrainingSet){
        _currentSet.value = trainingSet
        _currentSet.value = _currentSet.value
    }
    fun setCurrentTraining(training: Training){
        _currentTraining.value = training
        _currentTraining.value = _currentTraining.value
    }



    /*fun getLatestCharts(){
        var lastBodyStatChart : LiveData<List<Chart>> = repository.bodyStatChartlist.value!![repository.bodyStatChartlist.value!!.lastIndex]
        var lastProgressChart = repository.progressChartList.value!![repository.progressChartList.value!!.lastIndex]
        var latestCharts: LiveData<List<Chart>> = lastBodyStatChart
        latestCharts.add(lastBodyStatChart)

    }*/

    fun getSetListOfTraining(training: Training): List<TrainingSet> {


        return repository.getSetOfTraining(training)

    }

    fun getDetailOfTraining(trainingSet: TrainingSet): List<TrainingDetail> {
        return repository.getDetailOfSet(trainingSet)
    }

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

    fun getChartURL(): String{
        Log.d("ViewModel", "Function entered")

        var url = "https://image-charts.com/chart?cht=lc&chs=300x300"
        Log.d("ViewModel", "URL Created")

        var timestamps: String = ""
        Log.d("ViewModel", "Timestamp created")

        var weigts: String = ""
        Log.d("ViewModel", "Weights  created")

        var fats: String = ""
        Log.d("ViewModel", "Fats created")

        var waters: String =""
        Log.d("ViewModel", "Waters created")

        //println("BodStatList: " + repository.bodyStatsList.value)

        println("Viewmodel: " + bodyStatsList.value)

        if(bodyStatsList.value != null){
       bodyStatsList.value!!.forEach {

            timestamps = timestamps + it.btimestamp.toString() + "|"
            weigts = weigts + it.bweigt.toInt().toString() + ","
            fats = fats + it.bfat.toInt().toString() + ","
            waters = waters + it.bwater.toInt().toString() +  ","
        }
            println(timestamps)
            timestamps = timestamps.dropLast(1)
            println(timestamps)
            weigts = weigts.dropLast(1)
            fats = fats.dropLast(1)
            waters = waters.dropLast(1)

        url = "$url&chxt=x,y&chxl=0:|$timestamps&chd=a:$weigts|$fats|$waters&chxr=1,0,150"
        println(url)

        }
        return url
    }
}