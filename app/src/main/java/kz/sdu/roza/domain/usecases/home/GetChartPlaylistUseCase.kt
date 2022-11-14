package kz.sdu.roza.domain.usecases.home

import kz.sdu.roza.data.entities.Track
import kz.sdu.roza.domain.repository.ChartPlaylistRepository

class GetChartPlaylistUseCase(private val chartPlaylistRepository: ChartPlaylistRepository) {

    fun execute(id: Int): List<Track> {
        return chartPlaylistRepository.getPlaylist(id)
    }
}
