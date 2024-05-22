package com.kiosk.app

data class Item(
    val image: Int,
    val name: String,
    val basePrice: Int,
    val count: Int,
    var size: String,
    val shot: Boolean,
    val syrub: Boolean,
    val cream: Boolean,
) {
    val price: Int
        get() = basePrice * count
}