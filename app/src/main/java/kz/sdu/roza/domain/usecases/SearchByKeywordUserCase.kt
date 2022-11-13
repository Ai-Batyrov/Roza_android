package kz.sdu.roza.domain.usecases

import kz.sdu.roza.data.repository.SearchResultsRepositoryImplementation
import kz.sdu.roza.domain.repository.SearchResultsRepository

class SearchByKeywordUserCase(private val searchResults: SearchResultsRepository) {

    fun execute(text: String) {
        searchResults.getTracksByKeyword(text)
    }
}
