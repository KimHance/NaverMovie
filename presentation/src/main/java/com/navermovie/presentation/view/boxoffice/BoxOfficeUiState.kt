package com.navermovie.presentation.view.boxoffice

import com.navermovie.entity.Movie

sealed class BoxOfficeUiState {
    data class Success(val data: List<Movie>?) : BoxOfficeUiState()
    object Error : BoxOfficeUiState()
    data class Loading(val data: List<Movie>) : BoxOfficeUiState()
}
