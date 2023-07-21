package com.example.cleanarchiveapp1.data.local

@Database(entities = [MusicEntity::class], version = 1, exportSchema = false)
abstract class MusicDataBase : RoomDatabase() {

    abstract fun musicDao(): MusicDao
}