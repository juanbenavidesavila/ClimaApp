package com.example.climaapp.Models.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.climaapp.Models.local.ClimaAppDao
import com.example.climaapp.Models.local.entities.ClimaAppDetailEntity
import com.example.climaapp.Models.local.entities.ClimaAppEntity

@Database(entities=[ClimaAppEntity::class,ClimaAppDetailEntity::class], version = 1,
    exportSchema = false)
abstract class ClimaAppDataBase: RoomDatabase() {

    // REFERENCIA AL DAO PARTE LOCAL
    abstract fun getJpConcertDao(): ClimaAppDao


    companion object {
        @Volatile
        private var INSTANCE: ClimaAppDataBase? = null

        fun getDataBase(context: Context): ClimaAppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClimaAppDataBase::class.java,
                    "JpConcert"
                )

                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}