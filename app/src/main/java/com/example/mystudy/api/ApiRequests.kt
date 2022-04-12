package com.example.mystudy.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {

    @GET("/facts/random")
    fun getCatFacts(): Call<CatJson>
}