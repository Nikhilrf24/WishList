package com.example.wishlist_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var wishlist = ArrayList<Wishlist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit = findViewById<Button>(R.id.cart)
        val recycle = findViewById<RecyclerView>(R.id.recycleview)
        val item = findViewById<EditText>(R.id.item_name)
        val price = findViewById<EditText>(R.id.item_price)
        val url = findViewById<EditText>(R.id.url)

        submit.setOnClickListener {
            val entry = Wishlist(item.text.toString(), price.text.toString().toDouble(), url.text.toString())
            wishlist.add(entry)

            val adapter = WishListAdapter(wishlist)
            recycle.adapter = adapter

            recycle.layoutManager = LinearLayoutManager(this)
            item.text.clear()
            price.text.clear()
            url.text.clear()
        }
    }

}