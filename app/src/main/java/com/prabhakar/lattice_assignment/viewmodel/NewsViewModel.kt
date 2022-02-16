package com.prabhakar.lattice_assignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.prabhakar.lattice_assignment.remote.Resource
import com.prabhakar.lattice_assignment.remote.model.ArticlesModel
import com.prabhakar.lattice_assignment.repository.Repository
import kotlinx.coroutines.Dispatchers

class NewsViewModel : ViewModel() {
    /**
    Taking all News Data from repository
     */

    private val repository = Repository()
    fun showData(): LiveData<Resource<List<ArticlesModel?>>> {
        return liveData(Dispatchers.Main) {
            val data = repository.getDataFromServer()
            emit(data)
        }
    }

    /**
    Taking filter News Data from repository
     */

    fun searchData(query: String): LiveData<Resource<List<ArticlesModel?>>> {
        return liveData(Dispatchers.IO) {
            val data = repository.getSearchDataFromServer(query)
            emit(data)
        }
    }
}