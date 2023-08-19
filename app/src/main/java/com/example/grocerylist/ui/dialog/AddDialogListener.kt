package com.example.grocerylist.ui.dialog

import com.example.grocerylist.data.entities.GroceryItem

interface AddDialogListener {

    fun onButtonClickedItem(item: GroceryItem)

}