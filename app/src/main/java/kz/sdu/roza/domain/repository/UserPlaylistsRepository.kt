package kz.sdu.roza.domain.repository

import kz.sdu.roza.data.entities.Playlists

interface UserPlaylistsRepository {

    fun getPlaylists(): List<Playlists>
}
