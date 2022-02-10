package com.example.superheros.data.service

import com.example.superheros.core.di.RetrofitModule
import com.example.superheros.data.api.HeroApiClient
import com.example.superheros.data.model.HeroModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HeroService @Inject constructor() {

    private val retrofit = RetrofitModule.getRetrofit()

    suspend fun getAllHeros(): List<HeroModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(HeroApiClient::class.java).getAllHeros()
            response.body() ?: emptyList()
        }
    }

}