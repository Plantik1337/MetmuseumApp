package com.example.metmuseumapp.domain

import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.data.ObjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ObjectInteractorImpl @Inject constructor(private val objectRepository: ObjectRepository) :
    ObjectInteractor {

    override fun getObjectById(id: Int): Flow<ObjectInfo> = flow {
        emit(objectRepository.getObject(id))
    }.flowOn(Dispatchers.IO)
}