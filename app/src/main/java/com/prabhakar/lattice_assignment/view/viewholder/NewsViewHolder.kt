package com.prabhakar.lattice_assignment.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prabhakar.lattice_assignment.remote.model.ArticlesModel
import com.prabhakar.lattice_assignment.remote.model.ResponseModel
import kotlinx.android.synthetic.main.news_layout.view.*

class NewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setNewsData(model: ArticlesModel) {
        view.apply {
            Glide.with(image).load(model.urlToImage).into(image)
            title.text = model.title
            desc.text =model.description

        }
    }
}