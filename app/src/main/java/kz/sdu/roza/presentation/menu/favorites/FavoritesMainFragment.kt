package kz.sdu.roza.presentation.menu.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R

private const val TRACK_COUNT = "0"

class FavoritesMainFragment : Fragment() {
    private lateinit var trackList: RecyclerView
    private lateinit var favoritesViewModel: FavoritesViewModel

    private var trackCount: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritesViewModel =
            ViewModelProvider(this)[FavoritesViewModel::class.java]

        arguments?.let {
            trackCount = it.getString(TRACK_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites_main, container, false)

        trackList = view.findViewById(R.id.favorite_recycler_view)
        trackList.layoutManager = LinearLayoutManager(activity)
        favoritesViewModel.playlist.observe(viewLifecycleOwner) {
            trackList.adapter = FavoriteTrackListAdapter(it)
        }
        trackList.setHasFixedSize(true)

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
