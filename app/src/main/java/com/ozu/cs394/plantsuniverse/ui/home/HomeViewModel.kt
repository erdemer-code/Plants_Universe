package com.ozu.cs394.plantsuniverse.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozu.cs394.plantsuniverse.model.Plants
import com.ozu.cs394.plantsuniverse.room.PlantDAOImpl
import com.ozu.cs394.plantsuniverse.room.PlantDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel() : ViewModel() {
    val getAllPlantsLiveData = MutableLiveData<List<Plants>>()

    fun getAllPlants(context: Context){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getAllPlantsLiveData.postValue(PlantDAOImpl(PlantDatabase.getInstance(context)).getAllPlants())
            }
        }
    }

}
