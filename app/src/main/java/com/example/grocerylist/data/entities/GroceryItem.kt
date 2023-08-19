package com.example.grocerylist.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grocery_table")
class GroceryItem (
    @ColumnInfo("item_name")
    val name: String,
    @ColumnInfo("item_amount")
    var amount: Int
    ){
    @PrimaryKey(autoGenerate = true)
    var id :Int? =null
}