package kz.sdu.roza.presentation.menu.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.sdu.roza.data.repository.ChartPlaylistRepositoryData
import kz.sdu.roza.domain.usecases.home.GetChartPlaylistUseCase

class ChartPlaylistFactory(context: Context) : ViewModelProvider.Factory {

    private val chartPlaylistRepository by lazy(LazyThreadSafetyMode.NONE) {
        ChartPlaylistRepositoryData(context = context)
    }

    private val getChartPlaylistUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetChartPlaylistUseCase(chartPlaylistRepository = chartPlaylistRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChartPlaylistViewModel(getChartPlaylistUseCase) as T
    }
}
