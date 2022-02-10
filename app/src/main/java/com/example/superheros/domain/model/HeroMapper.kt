package com.example.superheros.domain.model

import com.example.superheros.data.model.*

fun HeroModel.toDomain(): Hero{
    return Hero(
        id = id,
        name = name,
        slug = slug,
        powerstats = powerstats.toDomain(),
        appearance = appearance.toDomain(),
        biography = biography.toDomain(),
        work = work.toDomain(),
        connections = connections.toDomain(),
        images = images.toDomain()
    )
}

fun PowerstatsModel.toDomain(): Powerstats{
    return Powerstats(
        intelligence = intelligence,
        strength = strength,
        speed = speed,
        durability = durability,
        power = power,
        combat = combat
    )
}

fun AppearanceModel.toDomain(): Appearance{
    return Appearance(
        gender = gender ?: "",
        race = race ?: "",
        height = height ?: listOf("", ""),
        weight = weight ?: listOf("", ""),
        eyeColor = eyeColor ?: "",
        hairColor = hairColor ?: ""
    )
}

fun BiographyModel.toDomain(): Biography{
    return Biography(
        fullName = fullName ?: "",
        alterEgos = alterEgos ?: "",
        aliases = aliases ?: listOf("", "", ""),
        placeOfBirth = placeOfBirth ?: "",
        firstAppearance = firstAppearance ?: "",
        publisher = publisher ?: "",
        alignment = alignment ?: "",
    )
}

fun WorkModel.toDomain(): Work{
    return Work(
        occupation = occupation,
        base = base
    )
}

fun ConnectionsModel.toDomain(): Connections{
    return Connections(
        groupAffiliation = groupAffiliation,
        relatives = relatives
    )
}

fun ImagesModel.toDomain(): Images{
    return Images(
        xs = xs,
        sm = sm,
        md = md,
        lg = lg
    )
}

