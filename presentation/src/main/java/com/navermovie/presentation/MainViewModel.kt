package com.navermovie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navermovie.entity.Movie
import com.navermovie.usecase.FetchMovieDetailUseCase
import com.navermovie.usecase.FetchMoviePosterUseCase
import com.navermovie.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val fetchMovieDetailUseCase: FetchMovieDetailUseCase,
    private val fetchMoviePosterUseCase: FetchMoviePosterUseCase
) : ViewModel() {

    private val _movieList = MutableStateFlow<List<Movie>>(emptyList())
    val movieList = _movieList.asStateFlow()


    fun fetchMovieList() {
        viewModelScope.launch {
            val fetchedMovieDetailJob = async {
                getMovieListUseCase()?.map {
                    fetchMovieDetailUseCase(it)
                }
            }
            val fetchMoviePosterJob = async(start = CoroutineStart.LAZY) {
                fetchedMovieDetailJob.await()?.map {
                    fetchMoviePosterUseCase(it)
                }
            }
            fetchMoviePosterJob.await()?.let { fetchedMovieList ->
                _movieList.value = fetchedMovieList
            }
        }
    }

}