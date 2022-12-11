package kz.sdu.roza.presentation.menu.playlists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.databinding.FragmentSingleUserPlaylistBinding
import kz.sdu.roza.presentation.menu.home.ChartPlaylistFactory
import kz.sdu.roza.presentation.menu.home.ChartPlaylistViewModel
import kz.sdu.roza.presentation.menu.home.SingleChartViewAdapter

private const val CHART_TITLE = "title"
private const val ID = "id"

class SingleUserPlaylistFragment : Fragment() {
    private var id: Int? = null
    private var title: String? = null

    private var _binding: FragmentSingleUserPlaylistBinding? = null
    private val binding: FragmentSingleUserPlaylistBinding get() = _binding!!

    private lateinit var playlist: RecyclerView

    private val playlistViewModel: ChartPlaylistViewModel by viewModels(
        factoryProducer = { ChartPlaylistFactory(requireContext()) }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ID)
            title = it.getString(CHART_TITLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSingleUserPlaylistBinding.inflate(inflater, container, false)
        binding.singleUserPlaylistTextviewTitle.text = title

        playlist = binding.singleUserPlaylistRecyclerView
        playlist.layoutManager = LinearLayoutManager(activity)

        playlistViewModel.getPlaylist(id!!)
        playlistViewModel.playlist.observe(viewLifecycleOwner) {
            playlist.adapter = SingleUserPlaylistAdapter(it)
        }
        playlist.setHasFixedSize(true)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int, title: String) =
            SingleUserPlaylistFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID, id)
                    putString(CHART_TITLE, title)
                }
            }
    }
}
