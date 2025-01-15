package com.example.metmuseumapp.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.metmuseumapp.data.RetrofitClient
import kotlinx.coroutines.launch

class ObjectViewModel : ViewModel() {
    fun fetchObjectInfo(objectId: Int) {
        viewModelScope.launch {
            try {
                val objectInfo = RetrofitClient.api.getObjectById(objectId)
                // Обработка полученных данных
                println("Название: ${objectInfo.title}")
            } catch (e: Exception) {
                // Обработка ошибок
                println("Ошибка: ${e.message}")
            }
        }
    }
}