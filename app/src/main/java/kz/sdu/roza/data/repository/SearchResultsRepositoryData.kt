package kz.sdu.roza.data.repository

import android.content.Context
import kz.sdu.roza.data.api.FavoritesAPI
import kz.sdu.roza.data.entities.Track
import kz.sdu.roza.domain.repository.SearchResultsRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val SEARCH_KEYWORD = "keyword"

class SearchResultsRepositoryData(context: Context) : SearchResultsRepository {
    private var api: FavoritesAPI = FavoritesAPI()
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun getTracksByKeyword(keyword: String): List<Track> {
        sharedPreferences.edit().putString(SEARCH_KEYWORD, "").apply()
        return api.getData()["tracks"] as List<Track>
    }
}
