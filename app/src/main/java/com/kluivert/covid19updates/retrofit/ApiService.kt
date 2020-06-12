package com.kluivert.covid19updates.retrofit


import com.kluivert.covid19updates.model.CasesData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    suspend fun getAll(): CasesData

    @GET("countries")
    suspend fun getCountriesData(): List<CasesData>

    companion object {
        fun create(): ApiService =
            Retrofit.Builder()
                .baseUrl("https://corona.lmao.ninja/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
    }
}
