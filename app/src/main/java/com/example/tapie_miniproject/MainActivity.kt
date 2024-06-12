package com.example.tapie_miniproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.KakaoMapSdk
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KakaoMapSdk.init(this, "8ecb0b96396e81ab9d1d89bc69fd41b2")
        enableEdgeToEdge()
        setContent {
            KakaoMap()
        }
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
            .systemBarsPadding(),
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
