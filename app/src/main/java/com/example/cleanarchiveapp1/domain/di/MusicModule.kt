package com.example.cleanarchiveapp1.domain.di

import android.content.Context
import com.example.cleanarchiveapp1.data.local.MusicDao
import com.example.cleanarchiveapp1.data.local.MusicDataBase
import com.example.cleanarchiveapp1.data.repositories.MusicRepositoryImpl


@Module
@InstallIn(SingletonComponent::class)
object MusicModule {

    @Singleton
    @Provides
    fun provideMusicDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context = context,
        MusicDataBase::class.java,
        "music"
    ).build()

    @Provides
    fun provideMusicDao(musicDataBase: MusicDataBase) = musicDataBase.musicDao()

    @Provides
    fun provideMusicRepository(musicDao: MusicDao): MusicRepository {
        return MusicRepositoryImpl(musicDao = musicDao)
    }
}