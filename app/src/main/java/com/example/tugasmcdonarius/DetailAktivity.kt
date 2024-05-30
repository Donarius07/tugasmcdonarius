package com.example.tugasmcdonarius

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmcdonarius.databinding.DetailBinding
import com.squareup.picasso.Picasso

class DetailAktivity : AppCompatActivity() {

    private lateinit var binding: DetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val nama = intent.getStringExtra("NAMA")
        val deskripsi = intent.getStringExtra("DESKRIPSI")
        val gambar = intent.getStringExtra("GAMBAR")
        val harga = intent.getStringExtra("HARGA")

        binding.tvNama.text = nama
        binding.tvHarga.text = harga
        binding.tvDeskripsi.text = deskripsi
        Picasso.get().load(gambar).into(binding.ivGambar)
    }
}
