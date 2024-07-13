package com.example.climaapp.Models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.climaapp.Models.Remote.RetrofitClient
import com.example.climaapp.Models.local.ClimaAppDao
import com.example.climaapp.Models.local.entities.ClimaAppDetailEntity

class ClimaAppRepository (private val climaAppDao: ClimaAppDao) {


    // retrofit Cliente

    private val networkService = RetrofitClient.retrofitInstance()

    // dao listado
    val climaappListLiveDataRepository = climaAppDao.getAllClimaApp()

    // un elemento

    val climaAppDetailLiveData= MutableLiveData<ClimaAppDetailEntity>()


    suspend fun fetchClima() {
        val service = kotlin.runCatching { networkService.fethClimaAppList() }
        service.onSuccess {
            when (it.code()) {
                in 200..299 -> it.body()?.let {
                    Log.d("climaapp", it.toString())
                    climaAppDao.insertAllClimaApp(fromInternetClimaAppEntity(it))
                }

                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error", "${it.message}")
            }
        }
    }
    suspend fun fetchClimaAppDetail(id:String): ClimaAppDetailEntity? {
        val service = kotlin.runCatching { networkService.fetchClimaAppDetail(id) }
        return service.getOrNull()?.body()?.let {climaappDetail ->

            val climaAppDetailEntity = fromInternetClimaAppDetailEntity(climaappDetail)
            climaAppDao.insertClimaAppDetail(climaAppDetailEntity)
            climaAppDetailEntity
        }
    }

}
