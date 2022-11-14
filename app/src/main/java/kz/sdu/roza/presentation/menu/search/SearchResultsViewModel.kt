package kz.sdu.roza.presentation.menu.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.sdu.roza.data.entities.Track
import kz.sdu.roza.domain.usecases.SearchByKeywordUseCase

class SearchResultsViewModel(
    private val searchByKeywordUseCase: SearchByKeywordUseCase
) : ViewModel() {
    private val _searchResults = MutableLiveData<List<Track>>()
    val searchResults: LiveData<List<Track>> = _searchResults

    fun searchResults(keyword: String) {
        _searchResults.value = searchByKeywordUseCase.execute(text = keyword)
    }
}
