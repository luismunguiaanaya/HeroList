package com.example.superheros.data.model

import com.google.gson.annotations.SerializedName

data class HeroModel(
    @SerializedName("id")  val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("slug") val slug : String,
    @SerializedName("powerstats") val powerstats : PowerstatsModel,
    @SerializedName("appearance") val appearance : AppearanceModel,
    @SerializedName("biography") val biography : BiographyModel,
    @SerializedName("work") val work : WorkModel,
    @SerializedName("connections") val connections : ConnectionsModel,
    @SerializedName("images") val images : ImagesModel
)

data class AppearanceModel (

    @SerializedName("gender") val gender : String,
    @SerializedName("race") val race : String,
    @SerializedName("height") val height : List<String>,
    @SerializedName("weight") val weight : List<String>,
    @SerializedName("eyeColor") val eyeColor : String,
    @SerializedName("hairColor") val hairColor : String
)

data class BiographyModel (

    @SerializedName("fullName") val fullName : String,
    @SerializedName("alterEgos") val alterEgos : String,
    @SerializedName("aliases") val aliases : List<String>,
    @SerializedName("placeOfBirth") val placeOfBirth : String,
    @SerializedName("firstAppearance") val firstAppearance : String,
    @SerializedName("publisher") val publisher : String,
    @SerializedName("alignment") val alignment : String
)

data class ConnectionsModel (

    @SerializedName("groupAffiliation") val groupAffiliation : String,
    @SerializedName("relatives") val relatives : String
)

data class ImagesModel (

    @SerializedName("xs") val xs : String,
    @SerializedName("sm") val sm : String,
    @SerializedName("md") val md : String,
    @SerializedName("lg") val lg : String
)

data class PowerstatsModel (

    @SerializedName("intelligence") val intelligence : Int,
    @SerializedName("strength") val strength : Int,
    @SerializedName("speed") val speed : Int,
    @SerializedName("durability") val durability : Int,
    @SerializedName("power") val power : Int,
    @SerializedName("combat") val combat : Int
)

data class WorkModel (

    @SerializedName("occupation") val occupation : String,
    @SerializedName("base") val base : String
)