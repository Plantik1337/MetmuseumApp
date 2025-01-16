package com.example.metmuseumapp.domain

import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.data.ObjectRepository
import com.example.metmuseumapp.data.ObjectRepositoryImpl

class ObjectInteractorImpl : ObjectInteractor {

    private lateinit var objectRepository: ObjectRepository

    override suspend fun getObjectById(id: Int): ObjectInfo {
        objectRepository = ObjectRepositoryImpl()
        return objectRepository.getObject(id)
    }
}