package com.example.cleanarchiveapp1.domain.usecases

import com.example.cleanarchiveapp1.domain.models.Music
import com.example.cleanarchiveapp1.domain.repositories.MusicRepository

class UpdateMusicUseCase @Inject constructor(private val musicRepository: MusicRepository) {
    suspend fun execute(music: Music) {
        musicRepository.updateMusic(music = music)
    }
}