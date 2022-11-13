package kz.sdu.roza.data.datasources

import kz.sdu.roza.data.enums.DataSourceTypes
import kz.sdu.roza.data.entities.Track

abstract class PlaylistDataSource {
    abstract fun setDataSourceType(sourceType: DataSourceTypes)

    abstract fun getList(): List<Track>

    abstract fun setData(data: List<Track>)
}
