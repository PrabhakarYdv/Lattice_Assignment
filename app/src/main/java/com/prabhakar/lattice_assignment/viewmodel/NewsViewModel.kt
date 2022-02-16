package com.prabhakar.lattice_assignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.prabhakar.lattice_assignment.remote.Resource
import com.prabhakar.lattice_assignment.remote.model.ArticlesModel
import com.prabhakar.lattice_assignment.repository.Repository
import kotlinx.coroutines.Dispatchers

class NewsViewModel : ViewModel() {
    private val repository = Repository()
    fun showData(): LiveData<Resource<List<ArticlesModel?>>> {
        return liveData(Dispatchers.Main) {
            val data = repository.getDataFromServer()
            emit(data)
        }
    }
}