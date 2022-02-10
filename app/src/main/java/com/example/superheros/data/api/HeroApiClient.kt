package com.example.superheros.data.api

import com.example.superheros.data.model.HeroModel
import retrofit2.Response
import retrofit2.http.GET

interface HeroApiClient {
    @GET("all.json")
    suspend fun getAllHeros(): Response<List<HeroModel>>
}