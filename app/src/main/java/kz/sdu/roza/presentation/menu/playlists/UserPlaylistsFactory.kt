package kz.sdu.roza.presentation.menu.playlists

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.sdu.roza.data.repository.UserPlaylistsRepositoryData
import kz.sdu.roza.domain.usecases.playlists.GetUserPlaylistsUseCase

class UserPlaylistsFactory(context: Context) : ViewModelProvider.Factory {

    private val userPlaylistsRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserPlaylistsRepositoryData(context)
    }

    private val getUserPlaylistsUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserPlaylistsUseCase(userPlaylistsRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserPlaylistsViewModel(getUserPlaylistsUseCase) as T
    }
}
