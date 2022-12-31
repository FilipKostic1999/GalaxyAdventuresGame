package com.example.galaxygame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val documentsList : ArrayList<messages>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {






    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int) : MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)

        return MyViewHolder(itemView)
    }





    override fun onBindViewHolder (holder: MyViewHolder, position: Int) {
        val document : messages = documentsList[position]
        holder.message.text = document.messageContent

    }









    override fun getItemCount(): Int {

        return  documentsList.size

    }






    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val message : TextView = itemView.findViewById(R.id.tvMessageContent)

    }









}

