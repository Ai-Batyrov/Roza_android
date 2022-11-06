package kz.sdu.roza.data.repository

import kz.sdu.roza.data.api.ChartAPI

class ChartsRepository {
    private var api: ChartAPI = ChartAPI("/chart/mixes")
}
