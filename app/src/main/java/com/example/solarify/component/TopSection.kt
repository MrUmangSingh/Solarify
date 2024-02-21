package com.example.solarify.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.solarify.screens.SignUp
import com.example.solarify.ui.theme.BackEnd
import com.example.solarify.ui.theme.BackStart
import com.example.solarify.ui.theme.OrangeStart
import com.example.solarify.ui.theme.PurpleEnd
import com.example.solarify.ui.theme.PurpleStart
import com.example.solarify.ui.theme.SolarifyTheme

@Composable
fun TopSection() {
    Box(modifier = Modifier
        .fillMaxWidth()
//        .background(Brush.horizontalGradient(colors = listOf(BackStart, BackEnd)))
        .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Hey,",
                fontSize = 17.sp,
                color = Color.White
            )
            Text(
                text = "User",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev1(){
    SolarifyTheme {
        TopSection()
    }
}