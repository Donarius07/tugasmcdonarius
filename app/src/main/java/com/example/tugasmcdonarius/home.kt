package com.example.tugasmcdonarius

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasmcdonarius.databinding.HomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage

class home : AppCompatActivity() {

    private lateinit var bukuListRecyclerView: RecyclerView
    private lateinit var bukuList: MutableList<image>
    private lateinit var bukuListAdapter: MyAdapter
    private lateinit var binding: HomeBinding
    private var mStorage: FirebaseStorage? = null
    private var mDatabaseRef: DatabaseReference? = null
    private var mDBListener: ValueEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bukuListRecyclerView = findViewById(R.id.movieLists)
        bukuListRecyclerView.setHasFixedSize(true)
        bukuListRecyclerView.layoutManager = LinearLayoutManager(this@home)
        binding.progres.visibility = View.VISIBLE
        bukuList = ArrayList()
        bukuListAdapter = MyAdapter(this@home, bukuList)
        bukuListRecyclerView.adapter = bukuListAdapter
        mStorage = FirebaseStorage.getInstance()
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("bukuList")

        mDBListener = mDatabaseRef!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@home, error.message, Toast.LENGTH_SHORT).show()
                binding.progres.visibility = View.INVISIBLE
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                bukuList.clear()
                for (teacherSnapshot in snapshot.children) {
                    val upload = teacherSnapshot.getValue(image::class.java)
                    upload!!.key = teacherSnapshot.key
                    bukuList.add(upload)
                }
                bukuListAdapter.notifyDataSetChanged()
                binding.progres.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                FirebaseAuth.getInstance().signOut()
                Intent(this, login::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        }
        return true
    }
}
