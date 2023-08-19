package com.example.grocerylist.data

import androidx.lifecycle.LiveData
import com.example.grocerylist.data.entities.GroceryItem

class GroceryRepository(private val groceryDao: GroceryDao) {

    suspend fun insertItem(item: GroceryItem){
        groceryDao.insertItem(item)
    }

    suspend fun deleteItem(item: GroceryItem){
        groceryDao.deleteItem(item)
    }

    fun getAllItems():LiveData<List<GroceryItem>>{
        return groceryDao.getAllGroceryItems()
    }

}