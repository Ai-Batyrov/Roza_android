package kz.sdu.roza.presentation.menu.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kz.sdu.roza.databinding.FragmentSearchMainBinding

private const val ARG_PARAM1 = "param1"

class SearchMainFragment : Fragment() {
    private var param1: String? = null

    private var _binding: FragmentSearchMainBinding? = null
    private val binding: FragmentSearchMainBinding get() = _binding!!
    private val searchViewModel: SearchResultsViewModel by viewModels(
        factoryProducer = { SearchResultsFactory(context = requireContext()) }
    )
    private lateinit var results: RecyclerView
    private lateinit var searchButton: MaterialButton
    private lateinit var textInput: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        searchViewModel =
//            ViewModelProvider(
//                this,
//                SearchResultsFactory(context = requireContext())
//            )[SearchResultsViewModel::class.java]

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchMainBinding.inflate(inflater, container, false)
        searchButton = binding.searchButtonSearch
        textInput = binding.searchSearchBarEditText

        results = binding.searchResultsRecyclerView
        results.layoutManager = LinearLayoutManager(activity)
        searchViewModel.searchResults.observe(viewLifecycleOwner) { resultsData ->
            results.adapter = SearchResultsAdapter(resultsData)
        }
        searchButton.setOnClickListener {
            searchViewModel.searchResults(textInput.text.toString())
        }
        results.setHasFixedSize(true)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
