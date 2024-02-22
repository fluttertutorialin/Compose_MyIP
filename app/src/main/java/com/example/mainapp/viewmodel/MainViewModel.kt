package com.example.mainapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.findmyip.model.ComputerDetails
import com.example.findmyip.repository.MainRepository
import com.example.findmyip.retrofit.ApiHelper
import com.example.findmyip.retrofit.RetrofitBuilder
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val computerDetails: MutableLiveData<Response<ComputerDetails>> = MutableLiveData()
    val getComputerDetails: LiveData<Response<ComputerDetails>> = computerDetails

    init {
        fetchDataComputerDetails()
    }

    private fun fetchDataComputerDetails() {
        viewModelScope.launch {
            try {
                val  getData = mainRepository.getUsers()
                computerDetails.value = getData
            } catch (e: Exception) {
                Log.e("Error" ,e.message.toString())
            }
        }
    }

    /*fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }*/

   @Suppress("UNCHECKED_CAST")
    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val savedStateHandle = extras.createSavedStateHandle()
                return MainViewModel(MainRepository(ApiHelper(RetrofitBuilder.apiService))) as T
            }
        }
    }
}