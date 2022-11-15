package kz.sdu.roza.domain.repository

import kz.sdu.roza.data.entities.Track

interface ChartPlaylistRepository {

    fun getPlaylist(id: Int): List<Track>
}
