package kz.sdu.roza.data.api

import kz.sdu.roza.data.entities.Track

class FavoritesAPI : BaseAPI {
    private lateinit var message: String
    private lateinit var data: MutableMap<String, MutableList<Track>?>

    init {
        message = "Resource are loaded"
        data = mutableMapOf(
            "tracks" to mutableListOf(
                Track(1, "uiid-1", "Say My Name", "David Guetta, Bebe Rexha, JBalvin"),
                Track(2, "uiid-1", "Wake Me Up", "Avicii"),
                Track(3, "uiid-1", "Şımarık", "Tarkan"),
                Track(4, "uiid-1", "Jackie Chan", "Tiesto, Dzeko, Preme, Post Malone"),
                Track(5, "uiid-1", "Duality", "Nicky Romero"),
                Track(6, "uiid-1", "Sunwaves", "Slider & Magnit, Radio Killer"),
                Track(7, "uiid-1", "Cartier", "Dopebwoy, 3robi, Chivv"),
                Track(8, "uiid-1", "Thumbs", "Sabrina Carpenter"),
                Track(9, "uiid-1", "Blinding Lights", "The Weeknd"),
                Track(10, "uiid-1", "Attention", "Charlie Puth")
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
