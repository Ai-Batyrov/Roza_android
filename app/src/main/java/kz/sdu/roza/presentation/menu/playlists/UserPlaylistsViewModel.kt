package kz.sdu.roza.presentation.menu.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.sdu.roza.data.entities.Playlists
import kz.sdu.roza.domain.usecases.playlists.GetUserPlaylistsUseCase

class UserPlaylistsViewModel(
    private val getUserPlaylistsUseCase: GetUserPlaylistsUseCase
) : ViewModel() {

    private val _playlist = MutableLiveData<List<Playlists>>()
    val playlist: LiveData<List<Playlists>> = _playlist

    fun getPlaylists() {
        _playlist.value = getUserPlaylistsUseCase.execute()
    }
}
