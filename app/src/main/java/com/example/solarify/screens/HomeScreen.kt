package com.example.solarify.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solarify.component.BottomNavigationBar
import com.example.solarify.component.CardSection
import com.example.solarify.component.TopSection
import com.example.solarify.ui.theme.BackEnd
import com.example.solarify.ui.theme.BackStart
import com.example.solarify.ui.theme.PurpleEnd
import com.example.solarify.ui.theme.PurpleStart
import com.example.solarify.ui.theme.SolarifyTheme

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Brush.horizontalGradient(colors = listOf(BackEnd, BackStart)))
        ) {
            TopSection()
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Brush.verticalGradient(colors = listOf(Color.White, Color.Gray)))
            ) {
                Spacer(modifier = Modifier.height(34.dp))
                CardSection()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev3(){
    SolarifyTheme {
        HomeScreen()
    }
}