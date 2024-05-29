package com.example.tugasmcdonarius

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val ItemData: ArrayList<ItemData>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class MyViewHolder(ItemData: View, listener: onItemClickListener) : RecyclerView.ViewHolder(ItemData) {
        val gambar: ImageView = ItemData.findViewById(R.id.image)
        val nama: TextView = ItemData.findViewById(R.id.Buku)
        val harga: TextView = ItemData.findViewById(R.id.Harga)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val ItemData = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            return MyViewHolder(ItemData, mListener)
        }

        override fun getItemCount(): Int = ItemData.size

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentItem = ItemData[position]
            holder.gambar.setImageResource(currentItem.gambar)
            holder.nama.text = currentItem.nama
            holder.harga.text = currentItem.harga
        }
    }

