package kz.sdu.roza.presentation.menu.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.repository.FavoritePlaylistRepository

private const val TRACK_COUNT = "0"

class FavoritesMainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var playlist: FavoritePlaylistRepository

    private var trackCount: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playlist = FavoritePlaylistRepository()
        arguments?.let {
            trackCount = it.getString(TRACK_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites_main, container, false)

        recyclerView = view.findViewById(R.id.favorite_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = FavoriteTrackListAdapter(playlist.getPlaylist())
        recyclerView.setHasFixedSize(true)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(trackCount: String) =
            FavoritesMainFragment().apply {
                arguments = Bundle().apply {
                    putString(TRACK_COUNT, trackCount)
                }
            }
    }
}
