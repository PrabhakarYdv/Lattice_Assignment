package com.prabhakar.lattice_assignment.view

import android.os.Bundle
import android.text.format.DateUtils
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.prabhakar.lattice_assignment.R
import kotlinx.android.synthetic.main.activity_details.*
import java.text.SimpleDateFormat
import java.util.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        backButton.setOnClickListener {
            finish()
        }
        if (intent != null) {
            Glide.with(newsImage).load(intent.getStringExtra("img")).placeholder(R.color.light_blue_600).into(newsImage)
            newsTitle.text = intent.getStringExtra("title")
            desc.text = intent.getStringExtra("desc")
            content.text = intent.getStringExtra("content")
            author.text = "Author: ${intent.getStringExtra("author")}"
            publishDate.text = "Publish At: ${getTimeAgo(intent.getStringExtra("date"))}"
        }
    }

    private fun getTimeAgo(date: String?): CharSequence? {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        format.timeZone = TimeZone.getTimeZone("GMT")
        val time: Long = format.parse(date).time
        val now = System.currentTimeMillis()
        return DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS)
    }
}