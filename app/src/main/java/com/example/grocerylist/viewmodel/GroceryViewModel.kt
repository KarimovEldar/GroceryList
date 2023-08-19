package com.example.grocerylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.grocerylist.data.GroceryDao
import com.example.grocerylist.data.GroceryDatabase
import com.example.grocerylist.data.entities.GroceryItem
import com.example.grocerylist.data.GroceryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroceryViewModel @Inject constructor(
    application: Application
): AndroidViewModel(application) {

    private val groceryDao: GroceryDao = GroceryDatabase.invoke(application).groceryDao()
    private val repository: GroceryRepository = GroceryRepository(groceryDao)
    val getAllItems: LiveData<List<GroceryItem>> = repository.getAllItems()

    fun insertItem(item : GroceryItem) = viewModelScope.launch (Dispatchers.IO) {
        repository.insertItem(item)
    }

    fun deleteItem(item : GroceryItem) = viewModelScope.launch (Dispatchers.IO){
        repository.deleteItem(item)
    }
}