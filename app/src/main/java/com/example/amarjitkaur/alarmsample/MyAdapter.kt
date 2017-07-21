package com.example.amarjitkaur.alarmsample

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class  MyAdapter(val context : Context, val items: ArrayList<Item>, val listener: (Item) -> Unit): RecyclerView.Adapter<MyAdapter.ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage = itemView.findViewById(R.id.itemImage) as ImageView
        val itemTitle = itemView.findViewById(R.id.itemTitle) as TextView

        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
            itemTitle.text = item.title
            itemImage.setImageResource(R.mipmap.ic_launcher)

            setOnClickListener {

//                val intent: Intent = Intent(context, ActionBarTabbs::class.java);
//                context.startActivity(intent)
                listener(item) }
        }
    }
}