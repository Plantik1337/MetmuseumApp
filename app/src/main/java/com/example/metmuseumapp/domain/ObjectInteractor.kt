package com.example.metmuseumapp.domain

import com.example.metmuseumapp.ObjectInfo
import kotlinx.coroutines.flow.Flow

interface ObjectInteractor {
    fun getObjectById(id: Int): Flow<ObjectInfo>
}