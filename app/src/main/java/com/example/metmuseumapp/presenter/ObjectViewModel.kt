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

    private lateinit var objectInteractor: ObjectInteractor

    companion object {
        private const val ID =  45734
    }

    private val currentObjectInfo = MutableLiveData<ObjectInfo>()
    val currentObjectLiveData: LiveData<ObjectInfo> = currentObjectInfo

    fun fetchObjectInfo() {

        objectInteractor = ObjectInteractorImpl()

        viewModelScope.launch {
            try {
                val objectInfo = objectInteractor.getObjectById(ID)
                currentObjectInfo.postValue(objectInfo)
            } catch (e: Exception) {
                println("Ошибка: ${e.message}")
            }
        }
    }
}