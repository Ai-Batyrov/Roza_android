package kz.sdu.roza.data.repository

import kz.sdu.roza.data.api.FavoritesAPI
import kz.sdu.roza.data.datasources.FavoritePlaylistDataSource
import kz.sdu.roza.data.entities.Track

class FavoritePlaylistRepository {
    private var api: FavoritesAPI = FavoritesAPI()
    private var dataSource: FavoritePlaylistDataSource = FavoritePlaylistDataSource()

    init {
        dataSource.setData(api.getData()["tracks"]!!)
    }

    fun getPlaylist(): List<Track> {
        return dataSource.getList()
    }

    fun saveTrack(track: Track) {
        api.insertItem(track)
        dataSource.setData(api.getData()["tracks"]!!)
    }
}
