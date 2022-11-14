package kz.sdu.roza.presentation.menu.burgermenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.sdu.roza.databinding.FragmentBurgerMenuBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BurgerMenuFragment : Fragment() {
    private var _binding: FragmentBurgerMenuBinding? = null
    private val binding: FragmentBurgerMenuBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBurgerMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BurgerMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
