package com.ozu.cs394.plantsuniverse.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ozu.cs394.plantsuniverse.model.Plants

@Database(entities = [Plants::class], version = 1, exportSchema = true)
abstract class PlantDatabase: RoomDatabase() {
    abstract fun plantDAO(): PlantDAO


    companion object {
        @Volatile
        private var instance: PlantDatabase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: readDB(context).also {
                instance = it
            }
        }

        private fun readDB(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PlantDatabase::class.java, "plantsDB"
        )
            .createFromAsset("database/plants.db")
            .build()

    }

}