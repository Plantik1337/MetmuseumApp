package com.example.metmuseumapp.data

import com.example.metmuseumapp.ObjectInfo

interface ObjectRepository {
    suspend fun getObject(id: Int): ObjectInfo
}