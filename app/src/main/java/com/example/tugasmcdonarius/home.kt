package com.example.tugasmcdonarius

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class home : AppCompatActivity() {
    private lateinit var bukuRecyclerView: RecyclerView
    private lateinit var bukuAdapter: MyAdapter
    private lateinit var listBuku:ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bukuRecyclerView=findViewById(R.id.movieLists)
        listBuku=ArrayList()

        listBuku.add(ItemData(R.drawable.img_10, "Ikigai","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_11, "George Orwell 1984","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_12, "Hidup AntiGalau","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_13, "Cerita Rakyat","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_14, "Tak pernah","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_15, "Slow Down","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_16, "Bicara Itu Seni","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_17, "Master Your Pain","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_18, "Anak Islam","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_19, "Spektrum","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_20, "Perempuan dititik Nol","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_21, "Milk and Honey","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_22, "Habbits","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_23, "Intligence","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_24, "Atomic habbits","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_25, "Agama Saintifik","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_26, "Dongeng","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_27, "Money","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_28, "The Power","Rp 150.000"))
        listBuku.add(ItemData(R.drawable.img_29, "Respect Myself","Rp 150.000"))

        bukuRecyclerView.layoutManager=LinearLayoutManager( this)
        bukuRecyclerView.setHasFixedSize(true)
        bukuAdapter = MyAdapter(listBuku)
        bukuRecyclerView.adapter=bukuAdapter

    }
}