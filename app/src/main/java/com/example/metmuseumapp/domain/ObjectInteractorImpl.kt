package com.example.metmuseumapp.domain

import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.data.ObjectRepository

class ObjectInteractorImpl(private val objectRepository: ObjectRepository) : ObjectInteractor {

    override suspend fun getObjectById(id: Int): ObjectInfo {
        return objectRepository.getObject(id)
    }
}