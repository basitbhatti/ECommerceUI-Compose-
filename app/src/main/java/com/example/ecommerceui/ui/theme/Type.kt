package com.example.ecommerceui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ecommerceui.R

// Set of Material typography styles to start with

val fontFamily = FontFamily(
    Font(R.font.lato_bold, FontWeight.Bold),
    Font(R.font.lato_reg, FontWeight.Medium),
    Font(R.font.lato_lite, FontWeight.Light)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)