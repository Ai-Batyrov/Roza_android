package kz.sdu.roza.presentation.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import kz.sdu.roza.R
import kz.sdu.roza.databinding.FragmentSettingsBinding

private const val USER_FULL_NAME = "user_full_name"
private const val USER_AVATAR_IMAGE_URL = "user_avatar_image_url"

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding get() = _binding!!

    private var userFullName: String? = null
    private var userAvatarImageUrl: String? = null

    private lateinit var editProfileButton: MaterialButton

    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userFullName = it.getString(USER_FULL_NAME)
            userAvatarImageUrl = it.getString(USER_AVATAR_IMAGE_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        editProfileButton = binding.settingsButtonEditProfile

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editProfileButton.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_settingsFragment_to_editProfileFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(userFullName: String, userAvatarImageUrl: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(USER_FULL_NAME, userFullName)
                    putString(USER_AVATAR_IMAGE_URL, userAvatarImageUrl)
                }
            }
    }
}
