package com.example.cleanarchiveapp1.presentation.base

import androidx.lifecycle.ViewModel
import com.example.cleanarchiveapp1.domain.utlis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel: ViewModel() {

    protected fun<T> Flow<Resource<T>>.collectData(
        state: MutableStateFlow<UiState<T>>
    ) {
        viewModelScope.launch {
            this@collectData.collect {
                when (it) {
                    is Resource.Loading -> {
                        state.value = UiState.Loading()
                    }

                    is Resource.Success -> {
                        if (it.data != null) {
                            state.value = UiState.Success(it.data)
                        }
                    }

                    is Resource.Error -> {
                        state.value = UiState.Error(it.message ?: "Error")
                    }
                }
            }
        }
    }

}