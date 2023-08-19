package com.example.grocerylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerylist.viewmodel.GroceryViewModel
import com.example.grocerylist.data.entities.GroceryItem
import com.example.grocerylist.databinding.ItemRowLayoutBinding

class GroceryAdapter(
    private val viewModel: GroceryViewModel
):RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {

    private var groceryList = emptyList<GroceryItem>()

    class GroceryViewHolder(val binding: ItemRowLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        return GroceryViewHolder(
            ItemRowLayoutBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val currentItem = groceryList[position]

        holder.binding.amountTextView.text = "${currentItem.amount}"
        holder.binding.nameTextView.text = currentItem.name

        holder.binding.deleteImageview.setOnClickListener{
            viewModel.deleteItem(currentItem)
        }

        holder.binding.plusImageView.setOnClickListener {
            currentItem.amount++
            viewModel.insertItem(currentItem)
        }

        holder.binding.minusImageView.setOnClickListener {
            if (currentItem.amount>1){
                currentItem.amount--
                viewModel.insertItem(currentItem)
            }else{
                viewModel.deleteItem(currentItem)
            }
        }

    }

    override fun getItemCount(): Int {
        return groceryList.size
    }

    fun setData(newItem:List<GroceryItem>){
        groceryList = newItem
        notifyDataSetChanged()
    }

}