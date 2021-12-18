package com.ozu.cs394.plantsuniverse.ui.detail

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozu.cs394.plantsuniverse.model.Plants
import com.ozu.cs394.plantsuniverse.room.PlantDAOImpl
import com.ozu.cs394.plantsuniverse.room.PlantDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel : ViewModel() {
    val getPlantLiveData = MutableLiveData<Plants>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun getPlant(context: Context, id:Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getPlantLiveData.postValue(PlantDAOImpl(PlantDatabase.getInstance(context)).getPlant(id))
            }
            loadingLiveData.value = true
        }
    }
}