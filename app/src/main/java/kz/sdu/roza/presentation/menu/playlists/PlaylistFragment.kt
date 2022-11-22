package kz.sdu.roza.presentation.menu.playlists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.repository.FavoritePlaylistRepository

private const val TRACK_COUNT = "0"

class PlaylistFragment : Fragment() {
    private lateinit var trackList: RecyclerView
    private var trackCount: String? = null

    private var repository: FavoritePlaylistRepository = FavoritePlaylistRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trackCount = it.getString(TRACK_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)
        trackList = view.findViewById(R.id.playlist_recycler_view)
        trackList.layoutManager = LinearLayoutManager(activity)
        trackList.adapter = PlaylistAdapter(repository.getPlaylist())
        val sortOptions = resources.getStringArray(R.array.sort_options)
        val arrayAdapter = ArrayAdapter(view.context, R.layout.dropdown_item, sortOptions)
        val autoCompleteTV = view.findViewById<AutoCompleteTextView>(R.id.sortByTextView)
        autoCompleteTV.setAdapter(arrayAdapter)
        trackList.setHasFixedSize(true)
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlaylistFragment().apply {
                arguments = Bundle().apply {
                    putString(TRACK_COUNT, trackCount)
                }
            }
    }
}
