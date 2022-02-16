package com.prabhakar.lattice_assignment.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.lattice_assignment.view.viewholder.NewsViewHolder
import com.prabhakar.lattice_assignment.R
import com.prabhakar.lattice_assignment.remote.model.ArticlesModel
import com.prabhakar.lattice_assignment.remote.model.ResponseModel

class NewsAdapter(private val newsList: List<ArticlesModel>) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_layout, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val model = newsList[position]
        holder.setNewsData(model)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}