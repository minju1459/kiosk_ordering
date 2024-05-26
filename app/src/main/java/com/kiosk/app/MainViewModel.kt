package com.kiosk.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _selectedItem = MutableLiveData<ItemDrink>()
    val selectedItem: LiveData<ItemDrink> get() = _selectedItem

    private val _totalItemCount = MutableLiveData<Int>()
    val totalItemCount: LiveData<Int> get() = _totalItemCount

    private val _totalItemPrice = MutableLiveData<Int>()
    val totalItemPrice: LiveData<Int> get() = _totalItemPrice

    fun setSelectedItem(item: ItemDrink) {
        _selectedItem.value = item
    }

    fun updateTotal(items: List<ItemDrink>) {
        val totalCount = items.sumOf { it.count }
        val totalPrice = items.sumOf { it.price }
        _totalItemCount.value = totalCount
        _totalItemPrice.value = totalPrice
    }
}

