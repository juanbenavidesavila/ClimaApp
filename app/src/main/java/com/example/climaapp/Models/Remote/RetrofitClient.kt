package com.example.climaapp.Models.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{

        //url


        private const val BASE_URL ="https://tiempo-e38el7dv5-talento-projects.vercel.app/data"

        lateinit var  retrofitInstance : Retrofit


        fun retrofitInstance(): ClimaAppApi{

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return  retrofit.create(ClimaAppApi::class.java)
        }
    }
}
