package com.example.climaapp.Models.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.climaapp.Models.local.entities.ClimaAppDetailEntity
import com.example.climaapp.Models.local.entities.ClimaAppEntity

@Dao
interface ClimaAppDao {


    // insertar lista
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllClimaApp(listClimaApp: List<ClimaAppEntity>)



    // seleccionar Listado

    @Query("SELECT * FROM climaapp_list_table ORDER BY id ASC")
    fun getAllClimaApp(): LiveData<List<ClimaAppEntity>>


    // inserta de a 1
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClimaAppDetail(climaapp: ClimaAppDetailEntity)


    @Query("SELECT * FROM ClimaApp_detail_table WHERE id=:id")
    fun getClimaAppDetailById(id: String): LiveData<ClimaAppDetailEntity>


}