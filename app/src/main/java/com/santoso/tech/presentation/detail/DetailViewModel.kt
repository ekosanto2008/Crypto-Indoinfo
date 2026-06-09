package com.santoso.tech.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santoso.tech.domain.usecase.GetCoinDetailUseCase
import com.santoso.tech.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(DetailState())
    val state: State<DetailState> = _state

    init {
        savedStateHandle.get<Int>("coinId")?.let { coinId ->
            getCoinDetail(coinId)
        }
    }

    private fun getCoinDetail(id: Int) {
        getCoinDetailUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = DetailState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = DetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
