package com.swyp.core.ui.base

sealed interface CommonUiEffect {

    data class ShowToast(
        val message: String,
    ) : CommonUiEffect

}