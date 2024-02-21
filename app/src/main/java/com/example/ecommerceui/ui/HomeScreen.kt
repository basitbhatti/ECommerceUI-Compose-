package com.example.ecommerceui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceui.R
import com.example.ecommerceui.model.Category
import com.example.ecommerceui.model.Product
import com.example.ecommerceui.ui.theme.BGWhite
import com.example.ecommerceui.ui.theme.GradientColorEnd
import com.example.ecommerceui.ui.theme.GradientColorStart
import com.example.ecommerceui.ui.theme.GreyIcon
import com.example.ecommerceui.ui.theme.LightBlueCard
import com.example.ecommerceui.ui.theme.LightGreenCard
import com.example.ecommerceui.ui.theme.LightOrangeCard
import com.example.ecommerceui.ui.theme.LightPinkCard
import com.example.ecommerceui.ui.theme.LightRed
import com.example.ecommerceui.ui.theme.WhiteTransparent
import com.example.ecommerceui.ui.theme.fontFamily


@Preview(showBackground = true)
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
            ChipSection(
                listOf(
                    Category("All", R.drawable.categories),
                    Category("Shoes", R.drawable.sneakers),
                    Category("Watches", R.drawable.smartwatch),
                    Category("Apparel", R.drawable.apparel)
                )
            )

            PopularProductSection(
                listOfProducts = listOf(
                    Product(
                        "Nike Shoe 2024",
                        "$12.20",
                        R.drawable.image_shoe,
                        true,
                        0.0f,
                        LightGreenCard
                    ), Product(
                        "Ikea Chair", "$10.20", R.drawable.chair, false, 0.0f, LightBlueCard
                    ), Product(
                        "LV Pink Bag", "$112.20", R.drawable.bag, false, 0.0f, LightPinkCard
                    ), Product(
                        "Apple Watch 6", "$212.20", R.drawable.watch, true, 0.0f, LightOrangeCard
                    )
                )
            )
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
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd
        ) {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(10.dp))
                    .background(LightRed), contentAlignment = Alignment.Center
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
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(160.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        GradientColorStart, GradientColorEnd
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
                    .fillMaxHeight()
                    .fillMaxWidth(0.35f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(WhiteTransparent),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Get the special discount",
                    fontSize = 10.sp,
                    fontFamily = fontFamily,
                    color = Color.White
                )
                Text(
                    text = "50%\nOFF",
                    fontSize = 46.sp,
                    lineHeight = 45.sp,
                    fontFamily = fontFamily,
                    color = Color.White
                )
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                Image(
                    painter = painterResource(id = R.drawable.image_shoe),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

        }


    }
}

@Composable
fun ChipSection(categories: List<Category>) {
    var selectedindex by remember {
        mutableStateOf(0)
    }
    LazyRow(
        modifier = Modifier.padding(horizontal = 7.5.dp)
    ) {
        items(categories.size) {
            val category = categories[it]
            Box(
                modifier = Modifier
                    .padding(7.5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .clickable { selectedindex = it },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 25.dp, vertical = 15.dp)
                ) {
                    Image(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = category.iconId),
                        contentDescription = ""
                    )
                    Text(
                        modifier = Modifier.padding(start = 15.dp),
                        text = category.name,
                        color = if (selectedindex == it) LightRed else GreyIcon
                    )
                }
            }
        }
    }
}

@Composable
fun PopularProductSection(listOfProducts: List<Product>) {

    Column(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Text(
            modifier = Modifier.padding(15.dp),
            text = "Popular",
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )

        LazyVerticalGrid(columns = GridCells.Adaptive(150.dp)) {
            items(listOfProducts.size) {
                val product = listOfProducts[it]
                ProductCard(product)
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 7.5.dp, end = 7.5.dp, top = 7.5.dp, bottom = 7.5.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(product.backgroundColor)
            .padding(vertical = 20.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
        ) {

            if (product.isNew) {
                Text(
                    text = "New",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.TopStart)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }

            Image(
                painter = painterResource(id = product.imageId),
                modifier = Modifier
                    .fillMaxSize()
                    .size(100.dp),
                contentDescription = ""
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
        ) {

            Text(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                text = product.name,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                fontSize = 20.sp
            )

            Text(
                modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                text = product.price,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 24.sp
            )


        }

    }


}