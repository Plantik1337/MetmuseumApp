package com.example.metmuseumapp.data

import com.example.metmuseumapp.ObjectInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface MetMuseumApi {
    @GET("public/collection/v1/objects/{id}")
    suspend fun getObjectById(@Path("id") id: Int): ObjectInfo
}