package kz.sdu.roza.presentation.menu.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.sdu.roza.data.models.Track
import kz.sdu.roza.data.repository.FavoritePlaylistRepository

class FavoritesViewModel : ViewModel() {
    private lateinit var playlist: MutableLiveData<List<Track>>
    private var repository: FavoritePlaylistRepository = FavoritePlaylistRepository()

    init {
        setPlaylist(repository.getPlaylist())
    }

    private fun setPlaylist(list: List<Track>) {
        playlist.value = list
    }

    fun getPlaylist(): MutableLiveData<List<Track>> {
        return playlist
    }
}
