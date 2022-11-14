package kz.sdu.roza.presentation.menu.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.sdu.roza.data.entities.Track
import kz.sdu.roza.domain.usecases.home.GetChartPlaylistUseCase

class ChartPlaylistViewModel(
    private val getChartPlaylistUseCase: GetChartPlaylistUseCase
) : ViewModel() {
    private val _playlist = MutableLiveData<List<Track>>()
    val playlist: LiveData<List<Track>> = _playlist

    fun getPlaylist(id: Int) {
        _playlist.value = getChartPlaylistUseCase.execute(id)
    }
}
