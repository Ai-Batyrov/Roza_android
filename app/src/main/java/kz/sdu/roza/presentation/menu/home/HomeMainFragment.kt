package kz.sdu.roza.presentation.menu.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.entities.Chart
import kz.sdu.roza.data.repository.ChartsRepository
import kz.sdu.roza.databinding.FragmentHomeMainBinding

private const val CHARTS_TITLE = "Top charts"

class HomeMainFragment : Fragment() {
    private var chartTitle: String? = null

    private var _binding: FragmentHomeMainBinding? = null
    private val binding: FragmentHomeMainBinding get() = _binding!!

    private lateinit var chartsList: RecyclerView
    private lateinit var dataSource: ChartsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            chartTitle = it.getString(CHARTS_TITLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeMainBinding.inflate(inflater, container, false)
        dataSource = ChartsRepository()

        chartsList = binding.homeChartRecyclerView
        chartsList.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        chartsList.adapter = ChartListAdapter(dataSource.getChartList())
        chartsList.setHasFixedSize(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance(chartsTitle: String) =
            HomeMainFragment().apply {
                arguments = Bundle().apply {
                    putString(CHARTS_TITLE, chartsTitle)
                }
            }
    }
}
