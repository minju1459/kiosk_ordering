package com.kiosk.app

data class ItemDrink(
    val image: Int,
    val name: String,
    val basePrice: Int,
    val count: Int,
    var size: String = "",
    val shot: String = "",
    val syrub: String = "",
    val cream: String = "",
) {
    val price: Int
        get() = basePrice * count
}