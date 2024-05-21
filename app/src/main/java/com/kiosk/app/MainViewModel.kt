package com.kiosk.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _selectedItem = MutableLiveData<Item>()
    val selectedItem: LiveData<Item>
        get() = _selectedItem

    fun setSelectedItem(item: Item) {
        _selectedItem.value = item
    }
}
