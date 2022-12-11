package kz.sdu.roza.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.sdu.roza.data.entities.User

class EditProfileViewModel : ViewModel() {
    //    private var firebaseDB = FirebaseDB()
    private var _user = MutableLiveData<User>();
    val user: LiveData<User>
        get() = _user

    fun setUser(firsName: String, lastName: String, username: String, email: String) {
//        firebaseDB.setReference("User")
//        _user.value = User(
//            firebaseDB.getDatabaseInstance().reference.key!!.toLong(),
//            firsName,
//            lastName,
//            username,
//            email
//        )
//
//        firebaseDB.getDatabaseInstance().reference.push().setValue(user)
    }
}
