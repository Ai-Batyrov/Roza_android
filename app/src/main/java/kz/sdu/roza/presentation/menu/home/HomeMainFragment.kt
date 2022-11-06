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

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeMainFragment : Fragment() {
    private lateinit var chartTitle: String
    private lateinit var chartsList: RecyclerView
    private lateinit var dataSource: ChartsDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            chartTitle = it.getString("chartTitle").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home_main, container, false)
        dataSource = ChartsDataSource()

        chartsList = view.findViewById(R.id.home_chart_recyclerView)
        chartsList.layoutManager = LinearLayoutManager(activity)

        chartsList.setHasFixedSize(true)

        return view
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeMainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
