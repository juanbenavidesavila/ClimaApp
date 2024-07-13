package com.example.climaapp.Models.Remote

import com.example.climaapp.Models.Remote.fromInternet.Clima
import com.example.climaapp.Models.Remote.fromInternet.ClimaDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ClimaAppApi {


    //class desde remote from internet

    @GET("ClimaApp")
    suspend fun fethClimaAppList(): Response<List<Clima>>


    @GET("ClimaApp/{id}")
    suspend fun fetchClimaAppDetail(@Path("id")id:String): Response<ClimaDetail>

}