package kz.sdu.roza.presentation.menu.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.datasources.ChartsDataSource
import kz.sdu.roza.data.models.Chart
import kz.sdu.roza.data.repository.ChartsRepository

private const val CHARTS_TITLE = "Top charts"

class HomeMainFragment : Fragment() {
    private var chartTitle: String? = null

    private lateinit var chartsList: RecyclerView
    private lateinit var dataSource_1: ChartsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            chartTitle = it.getString(CHARTS_TITLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_main, container, false)
        dataSource_1 = ChartsRepository()

        chartsList = view.findViewById(R.id.home_chart_recyclerView)
        chartsList.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        chartsList.adapter = ChartListAdapter(dataSource_1.getChartList())
        chartsList.setHasFixedSize(true)

        return view
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
