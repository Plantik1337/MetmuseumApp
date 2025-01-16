package com.example.metmuseumapp.data

import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.data.network.RetrofitClient

class ObjectRepositoryImpl : ObjectRepository {
    override suspend fun getObject(id: Int): ObjectInfo {
        return RetrofitClient.api.getObjectById(id)
    }
}