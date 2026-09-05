package com.swyp.core.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<S, E>(
    initialState: S,
) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _uiEffect = Channel<E>(Channel.BUFFERED)
    val uiEffect = _uiEffect.receiveAsFlow()

    private val _commonEffect =
        Channel<CommonUiEffect>(Channel.BUFFERED)

    val commonEffect =
        _commonEffect.receiveAsFlow()

    protected fun updateState(
        reducer: S.() -> S,
    ) {
        _uiState.update { it.reducer() }
    }

    protected fun sendEffect(effect: E) {
        viewModelScope.launch {
            _uiEffect.send(effect)
        }
    }

    protected fun sendCommonEffect(
        effect: CommonUiEffect,
    ) {
        viewModelScope.launch {
            _commonEffect.send(effect)
        }
    }

    protected fun showToast(message: String) {
        sendCommonEffect(
            CommonUiEffect.ShowToast(message),
        )
    }
}