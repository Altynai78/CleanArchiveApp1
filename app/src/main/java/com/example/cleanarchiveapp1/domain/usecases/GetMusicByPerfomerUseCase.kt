package com.example.cleanarchiveapp1.domain.usecases

import com.example.cleanarchiveapp1.domain.models.Music
import com.example.cleanarchiveapp1.domain.repositories.MusicRepository
import kotlinx.coroutines.flow.Flow


class GetMusicByPerfomerUseCase @Inject constructor(private val musicRepository: MusicRepository){

    fun execute(): Flow<Resource<List<Music>>> = musicRepository.getMusicsByPerfomer()

}