package com.example.grocerylist.ui.dialog

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.grocerylist.data.entities.GroceryItem
import com.example.grocerylist.databinding.DialogAddItemBinding

class AddItemDialog(context: Context, private val addDialogListener: AddDialogListener):AppCompatDialog(context) {
    private lateinit var binding : DialogAddItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addTextView.setOnClickListener{
            val name = binding.nameEditText.text.toString()
            val amount = binding.amountEditText.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please fill out all folders!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = GroceryItem(name,amount.toInt())
            addDialogListener.onButtonClickedItem(item)

            dismiss()

            binding.cancelTextView.setOnClickListener{
                cancel()
            }

        }


    }

}