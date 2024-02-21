package com.example.solarify.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.ElectricBolt
import androidx.compose.material.icons.rounded.EnergySavingsLeaf
import androidx.compose.material.icons.rounded.Lightbulb
import androidx.compose.material.icons.rounded.Percent
import androidx.compose.material.icons.rounded.Savings
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.solarify.screens.SignUp
import com.example.solarify.ui.theme.GreenEnd
import com.example.solarify.ui.theme.GreenStart
import com.example.solarify.ui.theme.OrangeEnd
import com.example.solarify.ui.theme.OrangeStart
import com.example.solarify.ui.theme.Pink40
import com.example.solarify.ui.theme.Purple80
import com.example.solarify.ui.theme.PurpleEnd
import com.example.solarify.ui.theme.PurpleStart
import com.example.solarify.ui.theme.SolarifyTheme
import com.example.solarify.ui.theme.YellowEnd
import com.example.solarify.ui.theme.YellowStart

@Composable
fun Tiles(name: String, backcolor: Color, iconback: Color, icon: ImageVector) {
    Box(modifier = Modifier
        .padding(6.dp)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(Brush.horizontalGradient(listOf(iconback, backcolor)))
                .width(168.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 20.dp, horizontal = 18.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .padding(6.dp)
                    .size(40.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = name,
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
            Text(
                text = name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )
        }
    }
}

@Composable
fun CardSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "   Dashboard",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
            )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Tiles(name = "Energy", backcolor = PurpleStart, iconback = PurpleEnd,icon = Icons.Rounded.EnergySavingsLeaf)
            Tiles(name = "Saving", backcolor = GreenStart, iconback = GreenEnd,icon = Icons.Rounded.Savings)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Tiles(name = "Solar Radiation", backcolor = YellowStart, iconback = YellowEnd,icon = Icons.Rounded.WbSunny)
            Tiles(name = "Electricity", backcolor = OrangeStart, iconback = OrangeEnd,icon = Icons.Rounded.ElectricBolt)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev2(){
    SolarifyTheme {
        CardSection()
    }
}