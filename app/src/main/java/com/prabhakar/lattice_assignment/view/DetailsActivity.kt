package com.prabhakar.lattice_assignment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.prabhakar.lattice_assignment.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        backButton.setOnClickListener {
            finish()
        }
        if (intent != null) {
            Glide.with(ivImageDetails).load(intent.getStringExtra("img")).into(ivImageDetails)
            tvTitle.text = intent.getStringExtra("title")
            tvCardSource.text = intent.getStringExtra("img")
            tvTitle.text = intent.getStringExtra("author")
            tvCardDate.text = intent.getStringExtra("date")
        }
    }
}