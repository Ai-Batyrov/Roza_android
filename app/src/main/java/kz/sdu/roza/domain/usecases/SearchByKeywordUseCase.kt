package kz.sdu.roza.domain.usecases

import kz.sdu.roza.data.entities.Track
import kz.sdu.roza.domain.repository.SearchResultsRepository

class SearchByKeywordUseCase(private val searchResultsRepository: SearchResultsRepository) {

    fun execute(text: String): List<Track> {
        return searchResultsRepository.getTracksByKeyword(text)
    }
}
