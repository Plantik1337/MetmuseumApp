package com.example.metmuseumapp

data class ObjectInfo(
    val objectID: Int,
    val title: String,
    val artistDisplayName: String,
    val objectDate: String,
    val primaryImage: String,
    val objectBeginDate: Int,
    val objectEndDate: Int,
    val primaryImageSmall: String,
    val artistRole: String,
    val artistDisplayBio: String,
    val department: String,
    val culture: String,
    val period: String,
    val medium: String,
    val dimensions: String

)
