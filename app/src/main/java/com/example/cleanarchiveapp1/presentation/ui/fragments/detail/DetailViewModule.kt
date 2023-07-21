package com.example.cleanarchiveapp1.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.example.cleanarchiveapp1.domain.models.Music
import com.example.cleanarchiveapp1.domain.usecases.DeleteMusicUseCase
import com.example.cleanarchiveapp1.domain.usecases.UpdateMusicUseCase
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateMusicUseCase: UpdateMusicUseCase,
    private val deleteMusicUseCase: DeleteMusicUseCase
) : ViewModel() {

    suspend fun updateMusic(music: Music) {
        viewModelScope.launch(Dispatchers.IO) {
            updateMusicUseCase.execute(music)
        }
    }

    suspend fun deleteMusic(music: Music) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteMusicUseCase.execute(music)
        }
    }
}