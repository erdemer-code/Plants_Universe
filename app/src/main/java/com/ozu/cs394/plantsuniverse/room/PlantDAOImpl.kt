package com.ozu.cs394.plantsuniverse.room

import androidx.lifecycle.LiveData
import com.ozu.cs394.plantsuniverse.model.Plants

class PlantDAOImpl(private val plantDatabase: PlantDatabase):PlantDAO {
    override fun getAllPlants(): List<Plants> = plantDatabase.plantDAO().getAllPlants().toList()
    override fun getPlant(id: Int): Plants = plantDatabase.plantDAO().getPlant(id)
}