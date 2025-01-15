package com.example.metmuseumapp.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.data.RetrofitClient
import kotlinx.coroutines.launch

class ObjectViewModel : ViewModel() {

    private val currentObjectInfo = MutableLiveData<ObjectInfo>()

    val currentObjectLiveData: LiveData<ObjectInfo> = currentObjectInfo

    fun fetchObjectInfo(objectId: Int) {

        viewModelScope.launch {
            try {
                val objectInfo = RetrofitClient.api.getObjectById(objectId)
                println("Название: ${objectInfo.title}")

                currentObjectInfo.postValue(objectInfo)
            } catch (e: Exception) {
                println("Ошибка: ${e.message}")
            }
        }
    }
}