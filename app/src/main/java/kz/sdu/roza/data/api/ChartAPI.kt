package kz.sdu.roza.data.api

import kz.sdu.roza.data.models.Chart

data class ChartAPI(val api: String) : BaseAPI {
    private lateinit var message: String
    private lateinit var data: MutableMap<String, List<Chart>>

    override fun fetchResource() {
        message = "Resource are loaded"
        data = mutableMapOf(
            "charts" to listOf(
                Chart(1, "Dancehall Hits", "Dopebwoy, JBalvin and more", "img/chart_cover"),
                Chart(2, "High Energy Songs", "Minelli, Inna, Ava Max and more", "img/chart_cover"),
                Chart(3, "House Mix", "David Guetta, Ilkay Sencan and more", "img/chart_cover"),
                Chart(
                    4,
                    "Dancehall Hits",
                    "Dan Berk, The Irrepressobles and more",
                    "img/chart_cover"
                ),
            )
        )
    }

    override fun getMessage(): String {
        return message
    }

    override fun getData(): Map<String, List<Chart>> {
        return data
    }
}
