package kz.sdu.roza.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.sdu.roza.data.entities.Profile

class SettingsViewModel: ViewModel() {
    private var _profile = MutableLiveData<Profile>()
    val profile: LiveData<Profile>
        get() = _profile

    fun updateInfo(firstName: String, lastName: String) {
        _profile.value = Profile(firstName, lastName)
    }
}