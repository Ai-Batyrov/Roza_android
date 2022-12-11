package kz.sdu.roza.presentation.menu.burgermenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import kz.sdu.roza.R
import kz.sdu.roza.databinding.FragmentBurgerMenuBinding

private const val USER_FULL_NAME = "user_full_name"
private const val USER_IMAGE_URL = "user_image_url"

class BurgerMenuFragment : Fragment() {
    private var userFullName: String? = null
    private var userImageURL: String? = null

    private var _binding: FragmentBurgerMenuBinding? = null
    private val binding: FragmentBurgerMenuBinding get() = _binding!!

    private lateinit var settingsLayout: ConstraintLayout
    private lateinit var playlistsLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            userFullName = bundle.getString(USER_FULL_NAME)
            userImageURL = bundle.getString(USER_IMAGE_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBurgerMenuBinding.inflate(inflater, container, false)
        settingsLayout = binding.burgerMenuLayoutSettings
        playlistsLayout = binding.burgerMenuLayoutPlaylists

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingsLayout.setOnClickListener {
            binding.root.findNavController()
                .navigate(R.id.action_burgerMenuFragment_to_settingsFragment)
        }
        playlistsLayout.setOnClickListener {
            binding.root.findNavController()
                .navigate(R.id.action_burgerMenuFragment_to_userPlaylistsFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(userFullName: String, userImageURL: String) =
            BurgerMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(USER_FULL_NAME, userFullName)
                    putString(USER_IMAGE_URL, userImageURL)
                }
            }
    }
}
