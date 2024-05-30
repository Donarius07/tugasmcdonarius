package com.example.tugasmcdonarius

import com.google.firebase.database.Exclude

data class image(
    var nama:String? = null,
    var gambar:String? = null,
    var deskripsi:String? = null,
    var harga : String?= null,
    @get:Exclude
    @set:Exclude
    var key: String? = null
)
