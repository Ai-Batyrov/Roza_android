package kz.sdu.roza.presentation.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kz.sdu.roza.R
import kz.sdu.roza.data.entities.Profile
import kz.sdu.roza.databinding.FragmentSettingsBinding

private const val USER_FULL_NAME = "param1"
private const val USER_AVATAR_IMAGE_URL = "param2"

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    private val viewModel: SettingsViewModel by activityViewModels()

    private var userFullName: String? = null
    private var userAvatarImageUrl: String? = null

    private lateinit var btn: Button

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn = binding.settingsButtonEditProfile
        btn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.editProfileFragment)
        }
        binding.settingsViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
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
