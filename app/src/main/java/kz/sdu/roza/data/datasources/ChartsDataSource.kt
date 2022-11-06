package kz.sdu.roza.data.datasources

import kz.sdu.roza.data.models.Chart

class ChartsDataSource : ListsDataSource() {
    private lateinit var charts: List<Chart>

    override fun setList(data: List<Any>) {
        charts = data as List<Chart>
    }

    override fun getList(): List<Any> {
        return charts
    }
}
