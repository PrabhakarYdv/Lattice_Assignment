package com.prabhakar.lattice_assignment.remote

import com.prabhakar.lattice_assignment.utill.Constraints
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Constraints.BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideAPIService(): APIService {
        return getRetrofitInstance().create(APIService::class.java)
    }
}