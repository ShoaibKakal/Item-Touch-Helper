package com.example.touchhelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SportsAdapter(val sportsArray: ArrayList<Sport>) :
    RecyclerView.Adapter<SportsAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val sportsImage: ImageView = view.findViewById(R.id.sportsImage)
        private val titleText: TextView = view.findViewById(R.id.title)
        private val infoText: TextView = view.findViewById(R.id.subTitle)

        fun bindTo(currentSport: Sport) {
            sportsImage.setImageResource(currentSport.imageResource)
            titleText.text = currentSport.title
            infoText.text = currentSport.info
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentSport = sportsArray[position]
        holder.bindTo(currentSport)
    }

    override fun getItemCount(): Int {
        return sportsArray.size
    }
}