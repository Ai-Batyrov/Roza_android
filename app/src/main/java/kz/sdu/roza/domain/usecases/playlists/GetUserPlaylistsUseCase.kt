package kz.sdu.roza.domain.usecases.playlists

import kz.sdu.roza.data.entities.Playlists
import kz.sdu.roza.domain.repository.UserPlaylistsRepository

class GetUserPlaylistsUseCase(private val userPlaylistRepository: UserPlaylistsRepository) {
    fun execute(): List<Playlists> {
        return userPlaylistRepository.getPlaylists()
    }
}
