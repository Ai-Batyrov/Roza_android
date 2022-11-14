package kz.sdu.roza.presentation.menu.burgermenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.imageview.ShapeableImageView
import kz.sdu.roza.R
import kz.sdu.roza.databinding.FragmentBurgerMenuBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BurgerMenuFragment : Fragment() {
    private var _binding: FragmentBurgerMenuBinding? = null
    private val binding: FragmentBurgerMenuBinding get() = _binding!!

    private lateinit var avatar: ShapeableImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBurgerMenuBinding.inflate(inflater, container, false)
        avatar = _binding!!.burgerMenuSettingsUserImage
        avatar.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_burgerMenuFragment_to_settingsFragment)
        }
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
