package kz.sdu.roza.presentation.menu.radiostations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import kz.sdu.roza.R
import kz.sdu.roza.databinding.FragmentRadioStationsMainBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RadioStationsMainFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentRadioStationsMainBinding? = null
    private val binding: FragmentRadioStationsMainBinding get() = _binding!!

    private lateinit var addRadioStationsButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            param1 = bundle.getString(ARG_PARAM1)
            param2 = bundle.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRadioStationsMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RadioStationsMainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
