package com.example.tugasmcdonarius

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailAktivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_aktivity)

        val gambar : ImageView=findViewById(R.id.ivGambar)
        val nama : TextView =findViewById(R.id.tvNama)
        val harga : TextView=findViewById(R.id.tvHarga)
        val deskripsi : TextView=findViewById(R.id.tvDeskripsi)

        val bundle:Bundle?=intent.extras
        val bNama = bundle!!.getString("idnama")
        val bGambar= bundle.getInt("idgambar")
        val bHarga= bundle.getString("idharga")
        val bDeskripsi=bundle.getString("iddeskripsi")

        gambar.setImageResource(bGambar)
        nama.text = bNama
        harga.text =bHarga
        deskripsi.text =bDeskripsi
    }
}