package kz.sdu.roza.presentation.menu.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SearchResultsFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchResultsViewModel() as T
    }
}
