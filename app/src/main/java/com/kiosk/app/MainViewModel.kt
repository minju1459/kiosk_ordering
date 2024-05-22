package com.kiosk.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _selectedItem = MutableLiveData<Item>()
    val selectedItem: LiveData<Item>
        get() = _selectedItem

    private val _selectedSize = MutableLiveData<String>()
    val selectedSize: LiveData<String> get() = _selectedSize

    fun setSelectedItem(item: Item) {
        _selectedItem.value = item
    }

    fun updateSizeText(size: String) {
        _selectedSize.value = size
    }

    private val _totalItemCount = MutableLiveData<Int>()
    val totalItemCount: LiveData<Int> get() = _totalItemCount

    private val _totalItemPrice = MutableLiveData<Int>()
    val totalItemPrice: LiveData<Int> get() = _totalItemPrice

    fun updateTotal(items: List<Item>) {
        val totalCount = items.sumOf { it.count }
        val totalPrice = items.sumOf { it.price * it.count }
        _totalItemCount.value = totalCount
        _totalItemPrice.value = totalPrice
    }
}
