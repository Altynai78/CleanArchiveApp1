package com.example.cleanarchiveapp1.data.repositories

import com.example.cleanarchiveapp1.data.base.BaseRepository
import com.example.cleanarchiveapp1.data.local.MusicDao
import kotlinx.coroutines.flow.Flow

class MusicRepositoryImpl @Inject constructor(private val musicDao: MusicDao) : BaseRepository(),
    MusicRepository {
    override suspend fun addMusic(music: Music) {
        musicDao.addMusic(music.toEntity())
    }

    override suspend fun updateMusic(music: Music){
        musicDao.updateMusic(music.toEntity())    }

    override suspend fun deleteMusic(music: Music){
        musicDao.deleteMusic(music.toEntity())
    }

    override fun getMusics(): Flow<Resource<List<Music>>> = doRequest { musicDao.getMusics().map { it.toMusic() } }

    override fun getMusicsByPerfomer(): Flow<Resource<List<Music>>> = doRequest { musicDao.getMusicByPerfomer().map { it.toMusic() } }

    override fun getMusicsByDuration(): Flow<Resource<List<Music>>> = doRequest { musicDao.getMusicByDuration().map { it.toMusic() } }
}