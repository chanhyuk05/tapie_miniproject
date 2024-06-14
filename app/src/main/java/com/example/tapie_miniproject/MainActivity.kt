package com.example.tapie_miniproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.tapie_miniproject.data.data_source.ApiResponse
import com.example.tapie_miniproject.data.data_source.GeoResponses
import com.example.tapie_miniproject.data.data_source.GeoRetrofit
import com.example.tapie_miniproject.data.data_source.RetrofitInstance
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.KakaoMapSdk
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KakaoMapSdk.init(this, "8ecb0b96396e81ab9d1d89bc69fd41b2")
        enableEdgeToEdge()
        reportMissingPerson()
        setContent {
            KakaoMap()
        }
    }


    private fun reportMissingPerson() {
        val call = RetrofitInstance.api.reportMissingPerson("10000647", "7a09589af6354b0d", "10")
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    Log.d("test", "hey")
                    val apiResponse = response.body()
                    apiResponse?.list?.forEach {
                        val call = GeoRetrofit.api.reportMissingPerson("KakaoAK c1d26ce24da260f69dd6c90cb9c38433","${it.occrAdres}")
                        call.enqueue(object : Callback<GeoResponses> {
                            override fun onResponse(
                                gcall: Call<GeoResponses>,
                                gresponse: Response<GeoResponses>
                            ) {
                                if (response.isSuccessful) {
                                    val GeoapiResponse = gresponse.body()
                                    Log.d("test", "${GeoapiResponse!!.documents[0].address_name} ${GeoapiResponse!!.documents[0].x} ${GeoapiResponse!!.documents[0].y}")
                                }
                                else {
                                    Log.d("test", "error")

                                }
                            }

                            override fun onFailure(gcall: Call<GeoResponses>, t: Throwable) {
                                Log.d("test", "$it $t")
                            }


                        })
                    }
                    Log.d("test", "$apiResponse")
                } else {
                    Log.d("test", "error")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("test", "error")
            }
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KakaoMap() {
    val context = LocalContext.current
    val mapView = rememberMapView(context = context)

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
        ) {
            AndroidView(
                factory = {
                    mapView
                },
            )
        }
    }
}

@Composable
fun rememberMapView(
    context: Context,
): MapView {
    val mapView = remember {
        MapView(context).also { mapView ->
            mapView.start(
                object : MapLifeCycleCallback() {
                    override fun onMapDestroy() {
                        Log.d("MapLifecycle", "onMapDestroy")
                    }
                    override fun onMapError(e: Exception?) {
                        Log.e("MapLifecycle", "onMapError", e)
                    }
                    override fun onMapResumed() {
                        Log.d("MapLifecycle", "onMapResumed")
                    }
                },

                object : KakaoMapReadyCallback() {
                    override fun onMapReady(map: KakaoMap) {
                        Log.d("MapLifecycle", "onMapReady")
                    }
                }
            )
        }
    }

    return mapView
}

