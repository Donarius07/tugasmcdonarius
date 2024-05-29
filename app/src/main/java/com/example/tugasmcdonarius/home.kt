package com.example.tugasmcdonarius

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class home : AppCompatActivity() {
    private lateinit var bukuRecyclerView: RecyclerView
    private lateinit var nama : Array<String>
    private lateinit var harga : Array<String>
    private lateinit var gambar : Array<Int>
    private lateinit var deskripsi : Array<String>
    private lateinit var listBuku:ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

       gambar = arrayOf(
           R.drawable.img_10,
           R.drawable.img_11,
           R.drawable.img_12,
           R.drawable.img_13,
           R.drawable.img_14,
           R.drawable.img_15,
           R.drawable.img_16,
           R.drawable.img_17,
           R.drawable.img_18,
           R.drawable.img_19,
       )

        nama = arrayOf(
            "Ikigai","George Orwell 1984","Hidup AntiGalau","Cerita Rakyat","Tak Pernah","Slow Down","Bicara Itu Seni",
            "Master Your Pain","Anak Islam","Spektrum","Perempuan dititik Nol","Milk and Honey","Habbits","Intligence",
            "Atomic habbits","Agama Saintifik","Dongeng","Money","The Power","Respect Myself"
        )
        harga = arrayOf(
            "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000",
            "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000",
            "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000", "Rp 150.000",
        )
        deskripsi = arrayOf(
            getString(R.string.Ikigai),
            getString(R.string.George_Orwell_1984),
            getString(R.string.Hidup_AntiGalau),
            getString(R.string.Cerita_Rakyat),
            getString(R.string.Tak_Pernah),
            getString(R.string.Slow_Down),
            getString(R.string.Bicara_Itu_Seni),
            getString(R.string.Master_Your_Pain),
            getString(R.string.Anak_Islam),
            getString(R.string.Spektrum),
        )

        bukuRecyclerView=findViewById(R.id.movieLists)
        bukuRecyclerView.layoutManager=LinearLayoutManager(this)

        listBuku= arrayListOf<ItemData>()
        getDataUser()
    }
    private fun getDataUser(){
        for (i in gambar.indices){
            val databuku =ItemData(gambar[i],nama[i],harga[i])
            listBuku.add(databuku)
        }
        var adapter= MyAdapter(listBuku)
        bukuRecyclerView.adapter=adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position:Int){
                intent= Intent(this@home,DetailAktivity::class.java)
                intent.putExtra("idgambar",listBuku[position].gambar)
                intent.putExtra("idnama",listBuku[position].nama)
                intent.putExtra("idharga",listBuku[position].harga)
                intent.putExtra("iddeskripsi",deskripsi[position])

                startActivity(intent)
            }
        })
    }
}