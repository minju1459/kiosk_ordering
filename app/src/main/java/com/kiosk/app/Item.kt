package com.kiosk.app

data class Item(
    val image: Int,
    val name: String,
    val basePrice: Int,
    val count: Int,
) {
    val price: Int
        get() = basePrice * count
}