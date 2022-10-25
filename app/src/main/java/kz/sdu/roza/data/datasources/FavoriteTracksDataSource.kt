package kz.sdu.roza.data.datasources

import kz.sdu.roza.data.models.Track

class FavoriteTracksDataSource {
    private val list = listOf<Track>(
        Track("Say My Name", "David Guetta, Bebe Rexha, JBalvin"),
        Track("Wake Me Up", "Avicii"),
        Track("Şımarık", "Tarkan"),
        Track("Jackie Chan", "Tiesto, Dzeko, Preme, Post Malone"),
        Track("Duality", "Nicky Romero"),
        Track("Sunwaves", "Slider & Magnit, Radio Killer"),
        Track("Cartier", "Dopebwoy, 3robi, Chivv"),
        Track("Thumbs", "Sabrina Carpenter"),
        Track("Blinding Lights", "The Weeknd"),
        Track("Attention", "Charlie Puth")
    )

    fun loadTracks(): List<Track> {
        return list
    }

}
