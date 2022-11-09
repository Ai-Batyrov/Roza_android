package kz.sdu.roza.presentation.menu.search


import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchBarViewModel(private val text: String) : ViewModel() {
    private lateinit var keyword: MutableLiveData<String>

    init {
        keyword.value = ""
        getKeyword()
    }

    fun setKeywordText(data: String) {
        keyword.value = data
    }

    fun getKeyword(): MutableLiveData<String> {
        return keyword
    }
}
