package com.prabhakar.lattice_assignment.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.lattice_assignment.R
import com.prabhakar.lattice_assignment.remote.model.ArticlesModel
import com.prabhakar.lattice_assignment.view.OnClickListener
import com.prabhakar.lattice_assignment.view.viewholder.NewsViewHolder

class NewsAdapter(
    private val newsList: List<ArticlesModel>,
    private val clickListener: OnClickListener,
) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_layout, parent, false)
        return NewsViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val model = newsList[position]
        holder.setNewsData(model)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}