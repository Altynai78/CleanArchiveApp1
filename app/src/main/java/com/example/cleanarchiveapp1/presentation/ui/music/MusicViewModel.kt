package com.example.cleanarchiveapp1.presentation.ui.music

import com.example.cleanarchiveapp1.domain.models.Music
import com.example.cleanarchiveapp1.domain.usecases.AddMusicUseCase
import com.example.cleanarchiveapp1.domain.usecases.GetMusicByDurationUseCase
import com.example.cleanarchiveapp1.domain.usecases.GetMusicByPerfomerUseCase
import com.example.cleanarchiveapp1.domain.usecases.GetMusicUseCase
import com.example.cleanarchiveapp1.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val getMusicUseCase: GetMusicUseCase,
    private val getMusicByPerfomerUseCase: GetMusicByPerfomerUseCase,
    private val getMusicByDurationUseCase: GetMusicByDurationUseCase,
    private val addMusicUseCase: AddMusicUseCase,
) : BaseViewModel() {

    private val _getAllMusicState = MutableStateFlow<UiState<List<Music>>>(UiState.EmptyState())
    val getAllMusicStates = _getAllMusicState.asStateFlow()

    fun addMusic(music: Music){
        viewModelScope.launch(Dispatchers.IO) {
            addMusicUseCase.execute(music)
        }
    }

    fun getAllMusic() = getMusicUseCase.execute().collectData(_getAllMusicState)

    fun getMusicByPerfomer() = getMusicByPerfomerUseCase.execute().collectData(_getAllMusicState)

    fun getMusicByDuration() = getMusicByDurationUseCase.execute().collectData(_getAllMusicState)
}