package com.example.ecommerceui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceui.R
import com.example.ecommerceui.ui.theme.BGWhite
import com.example.ecommerceui.ui.theme.GradientColorEnd
import com.example.ecommerceui.ui.theme.GradientColorStart
import com.example.ecommerceui.ui.theme.GreyIcon
import com.example.ecommerceui.ui.theme.LightRed
import com.example.ecommerceui.ui.theme.WhiteTransparent
import com.example.ecommerceui.ui.theme.fontFamily


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BGWhite)
    ) {
        Column {
            TopBarSection()
            SearchBarSection()
            BannerCardSection()
        }
    }
}

@Composable
fun TopBarSection() {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(horizontal = 15.dp)
    ) {

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "",
                modifier = Modifier.size(25.dp),
                tint = LightRed
            )
        }

        Text(text = "Home", fontFamily = fontFamily, fontWeight = FontWeight.Bold, fontSize = 22.sp)

        Row(
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.wallet),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp),
                    tint = LightRed
                )
            }

            Box(
                modifier = Modifier
                    .padding(start = 7.5.dp)
                    .size(40.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile_pic),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarSection() {

    var textValue by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 15.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(0.85f)
                .fillMaxHeight()

        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                ),
                trailingIcon = {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.search),
                        tint = GreyIcon,
                        contentDescription = "search icon"
                    )
                },
                value = textValue,
                onValueChange = {
                    textValue = it
                },
                label = { Text(text = "Seach") },
            )


        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.CenterEnd
        ) {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(10.dp))
                    .background(LightRed),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.setting),
                    tint = Color.White,
                    contentDescription = "filter icon"
                )
            }
        }


    }
}

@Composable
fun BannerCardSection() {
    Box(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(160.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        GradientColorStart,
                        GradientColorEnd
                    )
                )
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(0.3f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(WhiteTransparent),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


            }

        }


    }
}
