package kz.sdu.roza.presentation.menu.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.databinding.FragmentChartBinding

private const val CHART_TITLE = "title"
private const val ID = "id"

class ChartFragment : Fragment() {
    private var id: Int? = null
    private var title: String? = null

    private var _binding: FragmentChartBinding? = null
    private val binding: FragmentChartBinding get() = _binding!!

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
        _binding = FragmentChartBinding.inflate(inflater, container, false)
        binding.chartTextviewTitle.text = title

        playlist = binding.chartPlaylistRecyclerView
        playlist.layoutManager = LinearLayoutManager(activity)

        playlistViewModel.getPlaylist(id!!)
        playlistViewModel.playlist.observe(viewLifecycleOwner) { chartPlaylist ->
            playlist.adapter = SingleChartViewAdapter(chartPlaylist)
        }
        playlist.setHasFixedSize(true)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int, title: String) =
            ChartFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID, id)
                    putString(CHART_TITLE, title)
                }
            }
    }
}
