package com.example.tapie_miniproject.data.data_source

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface GeoCoder {
    interface ApiService {
        @POST("address")
        fun reportMissingPerson(
            @Header("Authorization") token: String?,
            @Query("query") query: String,
        ): Call<GeoResponses>
    }
}
// MainResponse.kt
data class GeoResponses(
    val documents: List<Document>,
    val meta: Meta
)

data class Document(
    val address_name: String,
    val address_type: String,
    val x: String,
    val y: String
)

data class Meta(
    val is_end: Boolean,
    val pageable_count: Int,
    val total_count: Int
)



object GeoRetrofit {
    private const val BASE_URL = "https://dapi.kakao.com/v2/local/search/"

    val api: GeoCoder.ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GeoCoder.ApiService::class.java)
    }
}