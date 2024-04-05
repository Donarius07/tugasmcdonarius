package com.example.tugasmcdonarius

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val ItemData:ArrayList<ItemData>):
    RecyclerView.Adapter<MyAdapter.MyViewholder>() {
    class MyViewholder (ItemData: View) : RecyclerView.ViewHolder(ItemData){
        val gambar : ImageView=ItemData.findViewById(R.id.image)
        val nama : TextView=ItemData.findViewById(R.id.Buku)
        val harga : TextView=ItemData.findViewById(R.id.Harga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val ItemData=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewholder(ItemData)
    }

    override fun getItemCount(): Int=ItemData.size

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
       val currentItem=ItemData[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.harga.text = currentItem.harga
    }
}