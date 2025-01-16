package com.example.metmuseumapp.domain

import com.example.metmuseumapp.ObjectInfo

interface ObjectInteractor {
    suspend fun getObjectById(id: Int): ObjectInfo
}