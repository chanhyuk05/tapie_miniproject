package com.example.tapie_miniproject.data.data_source

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

interface KidAPI {
    interface ApiService {
        @POST("lcm/findChildList.do")
        fun reportMissingPerson(
            @Query("esntlId") esntlId: String,
            @Query("authKey") authKey: String,
            @Query("rowSize") rowSize: String,
        ): Call<ApiResponse>
    }
}
data class MissingPerson(
    val esntlId: String,
    val authKey: String,
    val rowSize: String,
)

data class ApiResponse(
    val list: List<ResList>,
)
data class ResList(
    val occrde:String,
    val alldressingDscd: String,
    val ageNow: String,
    val age: String,
    val writngTrgetDscd: String,
    val sexdstnDscd: String,
    val occrAdres: String,
    val nm: String,
    val tknphotolength: String,
    val bdwgh: String
)
object RetrofitInstance {
    private const val BASE_URL = "https://www.safe182.go.kr/api/"

    val api: KidAPI.ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KidAPI.ApiService::class.java)
    }
}