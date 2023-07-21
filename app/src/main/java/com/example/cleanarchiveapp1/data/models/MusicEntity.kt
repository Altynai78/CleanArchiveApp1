package com.example.cleanarchiveapp1.data.models

    @Entity(tableName = "music")
    data class MusicEntity(
@PrimaryKey()
val id: Int,
val name: String,
val perfomer: String,
val duration: String,
)
