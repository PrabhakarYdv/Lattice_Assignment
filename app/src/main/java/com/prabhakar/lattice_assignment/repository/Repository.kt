package com.prabhakar.lattice_assignment.repository

import com.prabhakar.lattice_assignment.remote.Network
import com.prabhakar.lattice_assignment.remote.Resource
import com.prabhakar.lattice_assignment.remote.ResponseHandler
import com.prabhakar.lattice_assignment.remote.model.ArticlesModel

class Repository {
    private val apiService = Network.provideAPIService()
    private val responseHandler = ResponseHandler()

    /**
    Fetching data from server and passing to ViewModel
     */

        suspend fun getDataFromServer(): Resource<List<ArticlesModel?>> {
        val data = apiService.getNews().articles
        return try {
            responseHandler.handleSuccess(data)
        } catch (exception: Exception) {
            responseHandler.handleException(exception)
        }
    }
}