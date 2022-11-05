package kz.sdu.roza.data.datasources

import kz.sdu.roza.data.enums.DataSourceTypes
import kz.sdu.roza.data.models.Track

class FavoritePlaylistDataSource(
) : PlaylistDataSource() {
    private lateinit var datasourceType: DataSourceTypes
    private lateinit var playlist: List<Track>

    override fun setDataSourceType(sourceType: DataSourceTypes) {
        datasourceType = sourceType
    }

    override fun getList(): List<Track> {
        return playlist
    }

    override fun setData(data: List<Track>) {
        playlist = data
    }

}
