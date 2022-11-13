package kz.sdu.roza.presentation.menu.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchResultsViewModel : ViewModel() {
    private val keywordLiveData = MutableLiveData<String>()
}
