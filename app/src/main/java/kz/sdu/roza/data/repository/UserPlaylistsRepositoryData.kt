package kz.sdu.roza.data.repository

import android.content.Context
import kz.sdu.roza.data.entities.Playlists
import kz.sdu.roza.data.entities.Track
import kz.sdu.roza.domain.repository.ChartPlaylistRepository
import kz.sdu.roza.domain.repository.UserPlaylistsRepository
import java.util.Calendar

class UserPlaylistsRepositoryData(context: Context) : UserPlaylistsRepository {
    private var playlists: List<Playlists> = listOf(
        Playlists(
            1,
            "Chill Tracks",
            Calendar.getInstance().time.toString(),
            Calendar.getInstance().time.toString()
        ),
        Playlists(
            2,
            "Kazakh Songs",
            Calendar.getInstance().time.toString(),
            Calendar.getInstance().time.toString()
        ),
        Playlists(
            3,
            "EDM",
            Calendar.getInstance().time.toString(),
            Calendar.getInstance().time.toString()
        ),
        Playlists(
            4,
            "Rap",
            Calendar.getInstance().time.toString(),
            Calendar.getInstance().time.toString()
        )
    )

    override fun getPlaylists(): List<Playlists> {
        return playlists
    }
}
