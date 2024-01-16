package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class SlotsAdapter(private val dataList: List<SlotData>, private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<SlotsAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(data: SlotData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slot_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data, itemClickListener)
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewItem: TextView = itemView.findViewById(R.id.textViewItem)

        fun bind(data: SlotData, itemClickListener: OnItemClickListener) {
            textViewItem.text = data.text

            itemView.setOnClickListener {
                // Notify the listener when the item is clicked
                itemClickListener.onItemClick(data)
            }
        }
    }
}