package com.example.cleanarchiveapp1.domain.repositories

import com.example.cleanarchiveapp1.domain.models.Music
import kotlinx.coroutines.flow.Flow


interface MusicRepository {

    suspend fun addMusic(music: Music)

    fun getMusics(): Flow<Resource<List<Music>>>

    fun getMusicsByPerfomer(): Flow<Resource<List<Music>>>

    fun getMusicsByDuration(): Flow<Resource<List<Music>>>

    suspend fun updateMusic(music: Music)

    suspend fun deleteMusic(music: Music)
}