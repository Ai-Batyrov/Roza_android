package kz.sdu.roza.presentation.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import kz.sdu.roza.R
import kz.sdu.roza.databinding.FragmentEditProfileBinding

private const val USER_AVATAR_IMAGE_URL = "param1"
private const val USER_FIRSTNAME = "Aibolat"
private const val USER_LASTNAME = "Batyrov"
private const val USER_EMAIL = "aibolat.batyrov.03@gmail.com"

class EditProfileFragment : Fragment() {
    private var _binding: FragmentEditProfileBinding? = null
    private val binding: FragmentEditProfileBinding get() = _binding!!
    private val viewModel: SettingsViewModel by activityViewModels()
    private lateinit var cancelButton: Button
    private lateinit var saveButton: Button

    private var userAvatarImageUrl: String? = null
    private var userFirstName: String? = null
    private var userLastName: String? = null
    private var userEmail: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userAvatarImageUrl = it.getString(USER_AVATAR_IMAGE_URL)
            userFirstName = it.getString(USER_FIRSTNAME)
            userLastName = it.getString(USER_LASTNAME)
            userEmail = it.getString(USER_EMAIL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)

        cancelButton = _binding!!.editProfileButtonCancel
        saveButton = _binding!!.editProfileButtonSave

        cancelButton.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.settingsFragment)
        }

        saveButton.setOnClickListener {
            viewModel.updateInfo(
                binding.editProfileEdittextFirstname.text.toString(),
                binding.editProfileEdittextLastname.text.toString(),
            )
            Navigation.findNavController(binding.root).navigate(R.id.settingsFragment)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(
            userAvatarImageUrl: String,
            userFirstName: String,
            userLastName: String,
            userEmail: String
        ) =
            EditProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(USER_AVATAR_IMAGE_URL, userAvatarImageUrl)
                    putString(USER_FIRSTNAME, userFirstName)
                    putString(USER_LASTNAME, userLastName)
                    putString(USER_EMAIL, userEmail)
                }
            }
    }
}
