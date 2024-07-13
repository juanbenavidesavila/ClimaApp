package com.example.climaapp.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.climaapp.Models.ClimaAppRepository
import com.example.climaapp.Models.local.database.ClimaAppDataBase
import com.example.climaapp.Models.local.entities.ClimaAppDetailEntity
import com.example.climaapp.Models.local.entities.ClimaAppEntity
import kotlinx.coroutines.launch

class ClimaAppViewModels (application: Application): AndroidViewModel(application){


    // conexion repository
    private val repository : ClimaAppRepository
    // entidad
    private val climaAppDetailLiveData = MutableLiveData<ClimaAppDetailEntity>()
    // para seleccionar
    private var isSelected : String="-1"


    init{
        val bd= ClimaAppDataBase.getDataBase(application)
        val climaAppDao = bd.getJpConcertDao()
        repository= ClimaAppRepository(climaAppDao)

        //LAMAR A FECh

        viewModelScope.launch {
            repository.fetchClima()
        }
    }

    // listado de los elementos
    fun getClimaAppList(): LiveData<List<ClimaAppEntity>> = repository.climaappListLiveDataRepository

    // para obtener el detalle
    fun getClimaAppDetail() : LiveData<ClimaAppDetailEntity> = climaAppDetailLiveData

    fun getClimaAppDetailByIdFromInternet(id:String) = viewModelScope.launch {

        val climaAppDetail = repository.fetchClimaAppDetail(id)
        climaAppDetail?.let {
            climaAppDetailLiveData.postValue(it)
        }
    }
}