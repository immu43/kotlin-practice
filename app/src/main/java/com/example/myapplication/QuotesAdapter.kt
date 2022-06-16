package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class QuotesAdapter(private val context: Context,private val quotes : List<Result>,private val mRowLayout : Int) : RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mRowLayout, parent, false)
        return QuotesViewHolder(view)

    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {

        holder.content?.text = quotes[position].content
        holder.author?.text = quotes[position].author
        holder.date?.text = quotes[position].dateAdded
        holder.tag?.text = quotes[position].tags.toString()



    }

    override fun getItemCount(): Int {
       return quotes.size
    }

    class QuotesViewHolder(containerView : View) : RecyclerView.ViewHolder(containerView) {
        val content: TextView = containerView.findViewById<TextView>(R.id.tvContent)
        val author: TextView = containerView.findViewById<TextView>(R.id.tvAuthor)
        val date: TextView = containerView.findViewById<TextView>(R.id.tvDate)
        val tag: TextView = containerView.findViewById<TextView>(R.id.tvTags)
    }




}