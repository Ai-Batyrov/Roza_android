package kz.sdu.roza.presentation.menu.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.sdu.roza.R

private const val CHART_TITLE = "Classic Songs"
private const val TRACK_COUNT = 12

class ChartFragment : Fragment() {
    private var title: String? = null
    private var trackCount: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(CHART_TITLE)
            trackCount = it.getInt(TRACK_COUNT.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, trackCount: Int) =
            ChartFragment().apply {
                arguments = Bundle().apply {
                    putString(CHART_TITLE, title)
                    putInt(TRACK_COUNT.toString(), trackCount)
                }
            }
    }
}
