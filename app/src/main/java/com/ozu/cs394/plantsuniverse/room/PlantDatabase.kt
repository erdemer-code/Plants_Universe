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
        private var INSTANCE: PlantDatabase? = null

        fun getInstance(context: Context): PlantDatabase {
            if (INSTANCE == null) {
                synchronized(PlantDatabase::class) {
                    INSTANCE = readDB(context)
                }
            }
            return INSTANCE!!
        }
        private fun readDB(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PlantDatabase::class.java, "plantsDB"
        )
            .createFromAsset("database/plants.db")
            .build()

    }

}