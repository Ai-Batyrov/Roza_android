package kz.sdu.roza.data.repository

import android.content.Context
import kz.sdu.roza.data.entities.Track
import kz.sdu.roza.domain.repository.ChartPlaylistRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val CHART_ID = 3

class ChartPlaylistRepositoryData(context: Context) : ChartPlaylistRepository {
    private var playlist: List<Track> = listOf(
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

    private var sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun getPlaylist(id: Int): List<Track> {
        sharedPreferences.edit().putInt(CHART_ID.toString(), 1).apply()
        return playlist
    }
}
