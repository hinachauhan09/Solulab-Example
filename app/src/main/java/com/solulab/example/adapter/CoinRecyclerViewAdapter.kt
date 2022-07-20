package com.solulab.example.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.solulab.example.R
import com.solulab.example.model.Item

/**
 * Created by Hina Chauhan on 20-07-2022.
 */
class CoinRecyclerViewAdapter(var context: Context, var list: ArrayList<Item>) : RecyclerView.Adapter<CoinRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var name: TextView = itemView.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
//    Log.e("front",item.toString())
            holder.name.text = item.name
        if(item.pictures!=null)
            Glide.with(context).load(item.pictures.front.url)
                .placeholder(R.drawable.background)
                .into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}