package kz.sdu.roza.data.api

import kz.sdu.roza.data.entities.Chart

class UserChartsAPI(val api: String) : BaseAPI {
    private var message: String = ""
    private var data: MutableMap<String, List<Chart>> = mutableMapOf()

    init {
        message = "Resource are loaded"
        data = mutableMapOf(
            "charts" to listOf(
                Chart(1, "Dancehall Hits", "Dopebwoy, JBalvin and more"),
                Chart(2, "High Energy Songs", "Minelli, Inna, Ava Max and more"),
                Chart(3, "House Mix", "David Guetta, Ilkay Sencan and more"),
                Chart(
                    4,
                    "Classic Songs",
                    "Dan Berk, The Irrepressobles and more",
                ),
                Chart(
                    5,
                    "Kazakh Folk Songs",
                    "Toregali Toreali, Kairat Nurtas and more",
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

    override fun insertItem(item: Any?) {
        TODO("Not yet implemented")
    }
}
