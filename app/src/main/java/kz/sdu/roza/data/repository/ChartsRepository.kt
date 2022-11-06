package kz.sdu.roza.data.repository

import kz.sdu.roza.data.api.ChartAPI
import kz.sdu.roza.data.datasources.ChartsDataSource
import kz.sdu.roza.data.models.Chart

class ChartsRepository {
    private var api: ChartAPI = ChartAPI("/home")
    private var dataSource: ChartsDataSource = ChartsDataSource()

    init {
        api.fetchResource()
        dataSource.setList(api.getData()["charts"]!!)
    }

    fun getChartList(): List<Chart> {
        return dataSource.getList()
    }
}
