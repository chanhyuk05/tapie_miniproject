package com.example.tapie_miniproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApp()
//        }
//    }
////}
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyApp() {
//    Scaffold(
//        topBar = {
//            TopAppBar(title = { Text("교촌치킨 강남 2호점") },
//                colors = TopAppBarDefaults.topAppBarColors(containerColor = White, titleContentColor = Black)
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp)
//            ) {
//                Image(
//                    painter = rememberImage, // Your map image resource
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp),
//                    contentScale = ContentScale.Crop
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Text("조성훈", fontWeight = FontWeight.Bold, fontSize = 20.sp)
//                    Image(
//                        painter = painterResource(), // Your profile image resource
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(40.dp)
//                    )
//                }
//                Spacer(modifier = Modifier.height(8.dp))
//                Text("교촌 치킨 강남 2호점", fontSize = 16.sp, fontWeight = FontWeight.Bold)
//                Spacer(modifier = Modifier.height(8.dp))
//                DetailRow(label = "최종", value = "정보제공")
//                DetailRow(label = "전자결제 여부", value = "미확인")
//                DetailRow(label = "지역", value = "강남")
//                DetailRow(label = "상세 내용", value = "내 마음을 몰라 줘")
//            }
//        }
//    )
//}
//
//@Composable
//fun DetailRow(label: String, value: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 4.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(label, fontSize = 14.sp, color = Color.Gray)
//        Text(value, fontSize = 14.sp)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyApp()
//}