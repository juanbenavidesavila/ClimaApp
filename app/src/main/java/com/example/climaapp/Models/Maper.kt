package com.example.climaapp.Models

import com.example.climaapp.Models.Remote.fromInternet.Clima
import com.example.climaapp.Models.Remote.fromInternet.ClimaDetail
import com.example.climaapp.Models.local.entities.ClimaAppDetailEntity
import com.example.climaapp.Models.local.entities.ClimaAppEntity

fun fromInternetClimaAppEntity( climaAppList: List<Clima>) :List<ClimaAppEntity>{
    return climaAppList.map {
        ClimaAppEntity(

        id = it.id,
        ciudad = it.ciudad,
        region = it.region,
        imagen = it.imagen,
        temperatura = it.temperatura,
        viento = it.viento,
        amanecer = it.amanecer,
        atardecer = it.atardecer,
        detalle = it.detalle

        )


    }

}

fun fromInternetClimaAppDetailEntity( climaapp: ClimaDetail) : ClimaAppDetailEntity{
    return ClimaAppDetailEntity(

        id = climaapp.id,
        ciudad = climaapp.ciudad,
        region = climaapp.region,
        imagen = climaapp.imagen,
        temperatura = climaapp.temperatura,
        viento = climaapp.viento,
        amanecer = climaapp.amanecer,
        atardecer = climaapp.atardecer,
        detalle = climaapp.detalle

    )
}
