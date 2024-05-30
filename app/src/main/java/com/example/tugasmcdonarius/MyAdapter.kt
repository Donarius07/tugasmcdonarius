package com.example.tugasmcdonarius

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter( var mContext: Context,  var bukuList: List<image>) :
    RecyclerView.Adapter<MyAdapter.ListViewHolder>() {

    inner class ListViewHolder(var v: View) : RecyclerView.ViewHolder(v) {
        val gambar = v.findViewById<ImageView>(R.id.vwGambar)
        val nama = v.findViewById<TextView>(R.id.Buku)
        val harga= v.findViewById<TextView>(R.id.Harga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var v = inflater.inflate(R.layout.item, parent, false)
        return ListViewHolder(v)
    }
    override fun getItemCount(): Int = bukuList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var newList = bukuList[position]
        holder.nama.text = newList.nama
        holder.harga.text = newList.harga
        holder.gambar.loadImage(newList.gambar)
        holder.v.setOnClickListener {

            val nama = newList.nama
            val harga = newList.harga
            val deskripsi = newList.deskripsi
            val gambar = newList.gambar

            val mIntent = Intent(mContext, DetailAktivity::class.java)
                mIntent.putExtra("NAMA", nama)
            mIntent.putExtra("HARGA", harga)
                mIntent.putExtra("DESKRIPSI", deskripsi)
                mIntent.putExtra("GAMBAR", gambar)
                mContext.startActivity(mIntent)
        }
    }
}
