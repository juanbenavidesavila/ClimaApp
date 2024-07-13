package com.example.climaapp.Models.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ClimaApp_detail_table")
data class ClimaAppDetailEntity(


    @PrimaryKey
    val id: String,
    val ciudad: String,
    val region: String,
    val imagen: String,
    val temperatura: String,
    val viento: String,
    val amanecer: String,
    val atardecer: String,
    val detalle: String

)