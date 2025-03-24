package com.example.metmuseumapp.domain

import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.data.ObjectRepository
import javax.inject.Inject

class ObjectInteractorImpl @Inject constructor(private val objectRepository: ObjectRepository) :
    ObjectInteractor {

    override suspend fun getObjectById(id: Int): ObjectInfo {
        return objectRepository.getObject(id)
    }
}