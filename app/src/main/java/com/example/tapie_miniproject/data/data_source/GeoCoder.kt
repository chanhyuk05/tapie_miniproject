package com.example.tapie_miniproject.data.data_source

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

interface GeoCoder {
    interface ApiService {
        @POST("q={city name},{state code},{country code}&limit={limit}&appid={API key}")
        fun reportMissingPerson(
            @Query("esntlId") esntlId: String,
            @Query("authKey") authKey: String,
            @Query("rowSize") rowSize: String,
        ): Call<ApiResponse>
    }
}



object RetrofitI {
    private const val BASE_URL = "http://api.openweathermap.org/geo/1.0/direct/"

    val api: KidAPI.ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KidAPI.ApiService::class.java)
    }
}