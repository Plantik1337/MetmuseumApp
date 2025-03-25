package com.example.metmuseumapp.presenter.viewModel

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

    private val _currentObjectInfo = MutableLiveData<ObjectInfo>()
    val currentObjectLiveData: LiveData<ObjectInfo> = _currentObjectInfo

    fun fetchObjectInfo() {

        viewModelScope.launch {
            try {
                objectInteractor.getObjectById(ID)
                    .collect { objectInfo -> _currentObjectInfo.postValue(objectInfo) }

            } catch (e: Exception) {
                println("Ошибка: ${e.message}")
            }
        }
    }
}