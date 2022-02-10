package com.example.superheros.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Hero(
    val id : Int,
    val name : String,
    val slug : String,
    val powerstats : Powerstats,
    val appearance : Appearance,
    val biography : Biography,
    val work : Work,
    val connections : Connections,
    val images : Images
): Serializable

data class Appearance (

    val gender : String = "",
    val race : String = "",
    val height : List<String> = listOf("", ""),
    val weight : List<String> =  listOf("", ""),
    val eyeColor : String = "",
    val hairColor : String = ""
)

data class Biography (

    val fullName : String = "",
    val alterEgos : String = "",
    val aliases : List<String> = listOf("", ""),
    val placeOfBirth : String = "",
    val firstAppearance : String = "",
    val publisher : String = "",
    val alignment : String = "",
)

data class Connections (

    val groupAffiliation : String,
    val relatives : String
)

data class Images (

    val xs : String,
    val sm : String,
    val md : String,
    val lg : String
)

data class Powerstats (

    val intelligence : Int,
    val strength : Int,
    val speed : Int,
    val durability : Int,
    val power : Int,
    val combat : Int
)

data class Work (

    val occupation : String,
    val base : String
)