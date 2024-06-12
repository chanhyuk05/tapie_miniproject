package com.example.tapie_miniproject

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
import com.example.tapie_miniproject.ui.theme.Tapie_miniprojectTheme

class info : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Surface (
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){
                Screen()
            }
        }
    }
}

@Composable
fun Screen() {
    Box{
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
        {
            Text(
                text = "sunrininternet_highschool",
                fontSize = 32.sp,
            )
            Spacer(modifier = Modifier.padding(20.dp))
            TextField(
                label = { Text(text = "이름")},
                value = "",
                onValueChange = {}
            )
            TextField(
                label = { Text(text = "나이")},
                value = "",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {}
            )
            TextField(
                label = { Text(text = "생년월일")},
                value = "",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {}
            )
            TextField(
                label = { Text(text = "성별 (남자/여자)")},
                value = "",
                onValueChange = {}
            )
            Button(onClick = { /*  */ }, modifier=Modifier.width(280.dp)) {
                Text(text = "제출하기")

            }
        }
    }
}