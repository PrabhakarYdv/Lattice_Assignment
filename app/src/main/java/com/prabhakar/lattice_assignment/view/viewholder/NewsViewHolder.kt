package com.prabhakar.lattice_assignment.view.viewholder

import android.text.format.DateUtils
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prabhakar.lattice_assignment.R
import com.prabhakar.lattice_assignment.remote.model.ArticlesModel
import com.prabhakar.lattice_assignment.view.OnClickListener
import kotlinx.android.synthetic.main.news_layout.view.*
import java.text.SimpleDateFormat
import java.util.*

class NewsViewHolder(private val view: View, private val onClickListener: OnClickListener) :
    RecyclerView.ViewHolder(view) {
    fun setNewsData(model: ArticlesModel) {
        view.apply {
            Glide.with(image).load(model.urlToImage).placeholder(R.color.light_blue_600).into(image)
            title.text = model.title
            desc.text = model.description
            channel.text = model.source?.name
            timeAgo.text = "${getTimeAgo(model)}"

            /**
            applying click listener for each news
             */


            news.setOnClickListener {
                onClickListener.onClick(model, adapterPosition)
            }

        }
    }

    private fun getTimeAgo(model: ArticlesModel): CharSequence? {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        format.timeZone = TimeZone.getTimeZone("GMT")
        val time: Long = format.parse(model.publishedAt).time
        val now = System.currentTimeMillis()
        return DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS)

    }


}