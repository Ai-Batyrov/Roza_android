package kz.sdu.roza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.data.datasources.FavoriteTracksDataSource
import kz.sdu.roza.presentation.menu.favorites.FavoriteTrackListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var trackList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trackList = findViewById(R.id.favorite_recycler_view)

        val layoutManager = LinearLayoutManager(this)
        trackList.adapter = FavoriteTrackListAdapter(FavoriteTracksDataSource().loadTracks())
        trackList.layoutManager = layoutManager
        trackList.setHasFixedSize(true)
    }
}
