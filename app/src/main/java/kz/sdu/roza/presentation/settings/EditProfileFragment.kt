package kz.sdu.roza.presentation.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kz.sdu.roza.R
import kz.sdu.roza.data.dao.UserDAO
import kz.sdu.roza.data.db.AudioServiceDatabase
import kz.sdu.roza.data.entities.User
import kz.sdu.roza.databinding.FragmentEditProfileBinding

private const val USER_AVATAR_IMAGE_URL = "user_avatar_image_url"
private const val USER_FIRSTNAME = "user_firstname"
private const val USER_LASTNAME = "user_lastname"
private const val USER_EMAIL = "user_email"

class EditProfileFragment : Fragment() {
    private var _binding: FragmentEditProfileBinding? = null
    private val binding: FragmentEditProfileBinding get() = _binding!!

//    private val editProfileViewModel: EditProfileViewModel by viewModels()

    private lateinit var cancelButton: Button
    private lateinit var saveButton: Button
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var username: EditText
    private lateinit var country: Spinner
    private lateinit var firebaseDB: DatabaseReference
    private lateinit var userDao: UserDAO


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

        firebaseDB = Firebase.database.getReference("User")
        userDao = AudioServiceDatabase.getInstance(requireContext()).userDao

        cancelButton = binding.editProfileButtonCancel
        saveButton = binding.editProfileButtonSave
        username = binding.editProfileEdittextUsername
        firstName = binding.editProfileEdittextFirstname
        lastName = binding.editProfileEdittextLastname
        email = binding.editProfileEdittextEmail
        country = binding.editProfileSpinnerCountry

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cancelButton.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.settingsFragment)
        }
        saveButton.setOnClickListener {
            val user = User(
                1,
                firstName.text.toString(),
                lastName.text.toString(),
                username.text.toString(),
                email.text.toString()
            )

            lifecycleScope.launch {
                firebaseDB.setValue(user)
            }

            suspend {
                userDao.insert(user)
            }

            Navigation.findNavController(binding.root).navigate(R.id.settingsFragment)
        }
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
