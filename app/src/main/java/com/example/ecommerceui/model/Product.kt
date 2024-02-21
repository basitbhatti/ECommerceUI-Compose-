package com.example.ecommerceui.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Product(
    val name: String,
    val price: String,
    @DrawableRes val imageId: Int,
    val isNew: Boolean,
    val discount: Float,
    val backgroundColor : Color
)