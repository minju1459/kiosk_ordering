package com.kiosk.app

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var selectedItem: Item? = null

    fun setSelectedItem(item: Item) {
        selectedItem = item
    }

    fun getSelectedItem(): Item? {
        return selectedItem
    }
}
