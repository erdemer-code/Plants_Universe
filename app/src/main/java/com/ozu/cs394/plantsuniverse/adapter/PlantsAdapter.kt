package com.ozu.cs394.plantsuniverse.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ozu.cs394.plantsuniverse.R
import com.ozu.cs394.plantsuniverse.databinding.PlantItemBinding
import com.ozu.cs394.plantsuniverse.model.Plants

class PlantsAdapter(
    private val plantList: List<Plants>,
    private val onPlantClickListener: OnPlantClickListener?
) :
    RecyclerView.Adapter<PlantsAdapter.PlantsViewHolder>()
    /*ListAdapter<Plants, PlantsAdapter.PlantsViewHolder>(DiffCallback())*/ {


    inner class PlantsViewHolder(val bindView: PlantItemBinding) :
        RecyclerView.ViewHolder(bindView.root) {

        fun bind(position: Int) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsViewHolder =
        PlantsViewHolder(
            DataBindingUtil.inflate<PlantItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.plant_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PlantsViewHolder, position: Int) {
        holder.bindView.plant = plantList[position]
        holder.itemView.setOnClickListener {
            onPlantClickListener?.onClick(position)
        }
    }

    override fun getItemCount(): Int = plantList.size

}


/*class DiffCallback() : DiffUtil.ItemCallback<Plants>() {

    override fun areItemsTheSame(oldItem: Plants, newItem: Plants): Boolean {
        if (oldItem.id != newItem.id) return false
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Plants, newItem: Plants): Boolean {
        return oldItem == newItem
    }

}*/


interface OnPlantClickListener {
    fun onClick(position: Int)
}