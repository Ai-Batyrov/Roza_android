package kz.sdu.roza.data.repository

import kz.sdu.roza.data.api.FavoritesAPI
import kz.sdu.roza.data.entities.Track
import kz.sdu.roza.domain.repository.SearchResultsRepository

class SearchResultsRepositoryImplementation : SearchResultsRepository {
    private var api: FavoritesAPI = FavoritesAPI()

    override fun getTracksByKeyword(keyword: String): List<Track> {
        return api.getData()["tracks"] as List<Track>
    }
}
