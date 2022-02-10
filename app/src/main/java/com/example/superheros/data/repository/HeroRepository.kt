package com.example.superheros.data.repository


import com.example.superheros.data.model.HeroModel
import com.example.superheros.data.service.HeroService
import com.example.superheros.domain.model.Hero
import com.example.superheros.domain.model.toDomain
import javax.inject.Inject

class HeroRepository @Inject constructor(
    private val service: HeroService
) {

    suspend fun getAllHeros():List<Hero>{
        val response: List<HeroModel> = service.getAllHeros()
        return response.map{ it.toDomain() }
    }

}