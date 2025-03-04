package com.example.grocerylist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.grocerylist.data.entities.GroceryItem

@Database(entities = [GroceryItem::class], version = 1, exportSchema = false)
abstract class GroceryDatabase :RoomDatabase(){

    abstract fun groceryDao() : GroceryDao

    companion object{

        @Volatile
        private var instance: GroceryDatabase ?= null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                GroceryDatabase::class.java, "grocery_database").build()
    }
}
