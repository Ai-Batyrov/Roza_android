package kz.sdu.roza.data.api

import kz.sdu.roza.data.models.Track
import org.json.JSONObject

data class ChartAPI(val api: String) : BaseAPI {
    override fun fetchResource() {
        TODO("Not yet implemented")
    }

    override fun getMessage(): String {
        TODO("Not yet implemented")
    }

    override fun getData(): Map<String, List<Track>> {
        TODO("Not yet implemented")
    }
}
