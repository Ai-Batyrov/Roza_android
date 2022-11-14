package kz.sdu.roza.domain.repository

import kz.sdu.roza.data.entities.Track

interface SearchResultsRepository {

    fun getTracksByKeyword(keyword: String): List<Track>
}
