package kz.sdu.roza.data.repository

import kz.sdu.roza.data.api.UserChartsAPI
import kz.sdu.roza.data.datasources.ChartsDataSource
import kz.sdu.roza.data.entities.Chart

class ChartsRepository {
    private var api: UserChartsAPI = UserChartsAPI("/home")
    private var dataSource: ChartsDataSource = ChartsDataSource()

    init {
        dataSource.setList(api.getData()["charts"]!!)
    }

    fun getChartList(): List<Chart> {
        return dataSource.getList()
    }
}
