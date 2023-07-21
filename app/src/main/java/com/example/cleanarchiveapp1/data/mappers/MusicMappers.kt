package com.example.cleanarchiveapp1.data.mappers

fun Music.toEntity() : MusicEntity {
    return MusicEntity(id, name, perfomer, duration)
}

fun MusicEntity.toMusic() : Music {
    return Music(id, name, perfomer = perfomer, duration = duration)
}