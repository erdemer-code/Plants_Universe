package com.ozu.cs394.plantsuniverse.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.ozu.cs394.plantsuniverse.model.Plants
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDAO {


    @Query("SELECT * FROM plants")
    fun getAllPlants(): LiveData<List<Plants>>

    @Query("SELECT * FROM plants WHERE id = :id")
    fun getPlant(id:Int):LiveData<Plants>



}