package kz.sdu.roza.presentation.menu.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SearchBarKeywordFactory(val text: String) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchBarViewModel() as T
    }
}
