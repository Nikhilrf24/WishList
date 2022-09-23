package com.example.wishlist_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter(private val wishlist: List<Wishlist>) : RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTextView: TextView
        var priceTextView: TextView
        var linkTextView: TextView

        init {
            itemTextView = itemView.findViewById(R.id.item_name)
            priceTextView = itemView.findViewById(R.id.item_price)
            linkTextView = itemView.findViewById(R.id.item_url)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.itemlist, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = wishlist.get(position)
        holder.itemTextView.text = items.item
        holder.priceTextView.text = items.price.toString()
        holder.linkTextView.text = items.url
    }

    override fun getItemCount(): Int {
        return wishlist.size
    }


}