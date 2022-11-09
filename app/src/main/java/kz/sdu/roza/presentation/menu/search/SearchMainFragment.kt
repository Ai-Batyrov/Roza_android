package kz.sdu.roza.presentation.menu.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import kz.sdu.roza.R

private const val ARG_PARAM1 = "param1"

class SearchMainFragment : Fragment() {
    private var param1: String? = null
    private lateinit var searchBarTextViewModel: SearchBarViewModel
    private lateinit var searchBar: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_main, container, false)
//        searchBar = view.findViewById(R.id.search_search_bar_edit_text)
//        searchBarTextViewModel = ViewModelProvider(this)[SearchBarViewModel::class.java]
//        searchBarTextViewModel.setKeywordText(searchBar.text.toString())

//        searchBarTextViewModel.getKeyword().observe(viewLifecycleOwner) {
//            searchBar.setText(it)
//        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            SearchMainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
