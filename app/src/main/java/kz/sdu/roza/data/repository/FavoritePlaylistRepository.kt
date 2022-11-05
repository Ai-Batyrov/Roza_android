package kz.sdu.roza.data.repository

import kz.sdu.roza.data.api.FavoritesAPI
import kz.sdu.roza.data.datasources.FavoritePlaylistDataSource
import kz.sdu.roza.data.models.Track

class FavoritePlaylistRepository {
    private var api: FavoritesAPI = FavoritesAPI("/favorites")
    private var dataSource: FavoritePlaylistDataSource

    init {
        api.fetchResource()
        dataSource = FavoritePlaylistDataSource()
        dataSource.setData(api.getData()["tracks"]!!)
    }

    fun getPlaylist(): List<Track> {
        return dataSource.getList()
    }
}
