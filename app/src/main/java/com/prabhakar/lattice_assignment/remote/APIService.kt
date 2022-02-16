package com.prabhakar.lattice_assignment.remote

import com.prabhakar.lattice_assignment.remote.model.ResponseModel
import com.prabhakar.lattice_assignment.utill.Constraints
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    /**
    For all data
     */
    @GET(Constraints.END_POINT)
    suspend fun getNews(): ResponseModel

    /**
    For search data
     */
    @GET("everything")
    suspend fun getSearchedData(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String
    ): ResponseModel
}

/*
Query = ?domains=wsj.com&apiKey=444a4871d0284ce8981aa42f0111a518

//        @Query("domains") state: String,
//        @Query("apiKey") apiKey: String
 */