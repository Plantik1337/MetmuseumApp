package com.example.metmuseumapp.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.domain.ObjectInteractor
import com.example.metmuseumapp.domain.ObjectInteractorImpl
import kotlinx.coroutines.launch

class ObjectViewModel : ViewModel() {

    private val currentObjectInfo = MutableLiveData<ObjectInfo>()

    private lateinit var objectInteractor: ObjectInteractor

    val currentObjectLiveData: LiveData<ObjectInfo> = currentObjectInfo

    fun fetchObjectInfo(objectId: Int) {

        objectInteractor = ObjectInteractorImpl()

        viewModelScope.launch {
            try {
                val objectInfo = objectInteractor.getObjectById(objectId)
                currentObjectInfo.postValue(objectInfo)
            } catch (e: Exception) {
                println("Ошибка: ${e.message}")
            }
        }
    }
}