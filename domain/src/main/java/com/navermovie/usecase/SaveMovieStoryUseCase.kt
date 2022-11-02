package com.navermovie.usecase

import com.navermovie.repository.MovieRepository
import javax.inject.Inject

class SaveMovieStoryUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(code: String, story: String, date: Long) =
        repository.saveMovieStory(code, story, date)
}