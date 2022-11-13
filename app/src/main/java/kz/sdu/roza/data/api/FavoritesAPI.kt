package kz.sdu.roza.data.api

import kz.sdu.roza.data.entities.Track

class FavoritesAPI : BaseAPI {
    private lateinit var message: String
    private lateinit var data: MutableMap<String, MutableList<Track>?>

    init {
        message = "Resource are loaded"
        data = mutableMapOf(
            "tracks" to mutableListOf(
                Track("uiid-1", "Say My Name", "David Guetta, Bebe Rexha, JBalvin", "/url/img.png"),
                Track("uiid-1", "Wake Me Up", "Avicii", "/url/img.png"),
                Track("uiid-1", "Şımarık", "Tarkan", "/url/img.png"),
                Track("uiid-1", "Jackie Chan", "Tiesto, Dzeko, Preme, Post Malone", "/url/img.png"),
                Track("uiid-1", "Duality", "Nicky Romero", "/url/img.png"),
                Track("uiid-1", "Sunwaves", "Slider & Magnit, Radio Killer", "/url/img.png"),
                Track("uiid-1", "Cartier", "Dopebwoy, 3robi, Chivv", "/url/img.png"),
                Track("uiid-1", "Thumbs", "Sabrina Carpenter", "/url/img.png"),
                Track("uiid-1", "Blinding Lights", "The Weeknd", "/url/img.png"),
                Track("uiid-1", "Attention", "Charlie Puth", "/url/img.png")
            )
        )
    }

    override fun getMessage(): String {
        return message
    }

    override fun getData(): MutableMap<String, MutableList<Track>?> {
        return data
    }

    @Suppress("UNREACHABLE_CODE")
    override fun insertItem(item: Any?) {
        TODO("Пока что оставим данные локально")
        data["tracks"]?.add(item as Track)
    }

}
