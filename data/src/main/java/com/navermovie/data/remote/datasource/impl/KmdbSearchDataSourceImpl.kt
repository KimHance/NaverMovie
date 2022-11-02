package com.navermovie.data.remote.datasource.impl

import com.navermovie.data.remote.datasource.KmdbSearchDataSource
import com.navermovie.data.remote.service.KmdbSearchService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class KmdbSearchDataSourceImpl @Inject constructor(
    private val movieService: KmdbSearchService
) : KmdbSearchDataSource {
    override suspend fun getMoviePlot(title: String) = flow {
        emit(
            runCatching {
                movieService.getMoviePlot(title)
            }.getOrNull()
        )
    }
}