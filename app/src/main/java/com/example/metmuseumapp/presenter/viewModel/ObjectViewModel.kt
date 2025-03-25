package com.example.metmuseumapp.presenter.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.domain.ObjectInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class ObjectViewModel @Inject constructor(private val objectInteractor: ObjectInteractor) :
    ViewModel() {

    companion object {
        private const val ID = 436535
    }

    private val currentObjectInfo = MutableLiveData<ObjectInfo>()
    val currentObjectLiveData: LiveData<ObjectInfo> = currentObjectInfo

    fun fetchObjectInfo() {

        viewModelScope.launch {
            try {
                val objectInfo = objectInteractor.getObjectById(ID)
                Log.i("data", objectInfo.toString())
                currentObjectInfo.postValue(objectInfo)
            } catch (e: Exception) {
                println("Ошибка: ${e.message}")
            }
        }
    }
}