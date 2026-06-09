package com.santoso.tech.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santoso.tech.domain.usecase.GetCoinsUseCase
import com.santoso.tech.domain.usecase.GetGlobalMetricsUseCase
import com.santoso.tech.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val getGlobalMetricsUseCase: GetGlobalMetricsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        refresh()
    }

    fun refresh() {
        getGlobalMetrics()
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        coins = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        error = result.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getGlobalMetrics() {
        getGlobalMetricsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        globalMetrics = result.data
                    )
                }
                is Resource.Error -> {
                    // silent error or handle accordingly
                }
                is Resource.Loading -> {
                    // global metrics loading
                }
            }
        }.launchIn(viewModelScope)
    }
}
