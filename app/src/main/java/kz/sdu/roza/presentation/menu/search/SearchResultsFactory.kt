package kz.sdu.roza.presentation.menu.search

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.sdu.roza.data.repository.SearchResultsRepositoryData
import kz.sdu.roza.domain.usecases.SearchByKeywordUseCase

class SearchResultsFactory(context: Context) : ViewModelProvider.Factory {

    private val searchResultsRepository by lazy(LazyThreadSafetyMode.NONE) {
        SearchResultsRepositoryData(context = context)
    }

    private val searchByKeywordUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SearchByKeywordUseCase(searchResultsRepository = searchResultsRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchResultsViewModel(
            searchByKeywordUseCase = searchByKeywordUseCase
        ) as T
    }
}
