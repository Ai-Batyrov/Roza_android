package kz.sdu.roza.presentation.menu.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.sdu.roza.data.entities.Track
import kz.sdu.roza.data.repository.FavoritePlaylistRepository

class FavoritesViewModel : ViewModel() {
    private val playlistLiveData = MutableLiveData<List<Track>>()
    private var repository: FavoritePlaylistRepository = FavoritePlaylistRepository()
    val playlist: LiveData<List<Track>> = playlistLiveData

    init {
        setPlaylist(repository.getPlaylist())
    }

    private fun setPlaylist(list: List<Track>) {
        playlistLiveData.value = list
    }
}
