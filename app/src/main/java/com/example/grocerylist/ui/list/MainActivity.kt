package com.example.grocerylist.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerylist.viewmodel.GroceryViewModel
import com.example.grocerylist.adapter.GroceryAdapter
import com.example.grocerylist.data.entities.GroceryItem
import com.example.grocerylist.databinding.ActivityMainBinding
import com.example.grocerylist.ui.dialog.AddDialogListener
import com.example.grocerylist.ui.dialog.AddItemDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: GroceryViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel = ViewModelProvider(this)[GroceryViewModel::class.java]

        val adapter = GroceryAdapter(viewmodel)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewmodel.getAllItems.observe(this){
            adapter.setData(it)
        }

        binding.addFab.setOnClickListener {
            AddItemDialog(this, object : AddDialogListener {
                override fun onButtonClickedItem(item: GroceryItem) {
                    viewmodel.insertItem(item)
                }
            }).show()

        }

    }
}