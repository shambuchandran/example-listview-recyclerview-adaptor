package com.example.practiceall

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class RvAdaptor(var datalist: ArrayList<Dataclass>, var context: Activity) :
    RecyclerView.Adapter<RvAdaptor.RvViewHolder>() {

    interface onItemClickedListen {
        fun onItemClicked(position: Int)
    }

    private lateinit var listen: onItemClickedListen

    fun setitemclick(listener: onItemClickedListen) {
        listen = listener
    }

    class RvViewHolder(dataView: View, newListener: onItemClickedListen) :
        RecyclerView.ViewHolder(dataView) {
        val image = dataView.findViewById<ImageView>(R.id.image)
        val title = dataView.findViewById<TextView>(R.id.title)

        init {
            dataView.setOnClickListener {
                newListener.onItemClicked(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdaptor.RvViewHolder {
        val ItemView =
            LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        return RvViewHolder(ItemView, listen)
    }

    override fun onBindViewHolder(holder: RvAdaptor.RvViewHolder, position: Int) {
        var currentItem = datalist[position]
        holder.image.setImageResource(currentItem.dataImage)
        holder.title.text = currentItem.dataTitle
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

}