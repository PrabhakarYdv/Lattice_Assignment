package com.prabhakar.lattice_assignment.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabhakar.lattice_assignment.R
import com.prabhakar.lattice_assignment.remote.Status
import com.prabhakar.lattice_assignment.remote.model.ArticlesModel
import com.prabhakar.lattice_assignment.view.adapter.NewsAdapter
import com.prabhakar.lattice_assignment.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    private var dataList = mutableListOf<ArticlesModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
        Initializing ViewModel
         */
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        /**
        Starting Animation before loading Content
         */
        loading.startShimmerAnimation()


        /**
        Calling Function of ViewModel for get all Data
         */

        viewModel.showData().observe(this, Observer {
            it?.run {
                when (this.status) {
                    Status.ERROR -> {
                        Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                    }
                    Status.LOADING -> {
                        loading.visibility = View.VISIBLE
                        loading.startShimmerAnimation()
                        recyclerView.visibility = View.GONE

                    }

                    Status.SUCCESS -> {
                        searchLayout.visibility = View.VISIBLE
                        recyclerView.visibility = View.VISIBLE
                        loading.visibility = View.GONE
                        dataList = this.data as MutableList<ArticlesModel>
//                        newsAdapter.notifyDataSetChanged()
                        setRecyclerView()
                    }
                }
            }
        })

//        setRecyclerView()
        searchData()
    }

    /**
    Setting RecyclerView
     */
    private fun setRecyclerView() {
        newsAdapter = NewsAdapter(dataList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = newsAdapter
    }

    /**
    Searching News
     */
    private fun searchData() {
        search.addTextChangedListener {
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    viewModel.searchData(text.toString()).observe(this@MainActivity, Observer {
                        it?.run {
                            when (this.status) {
                                Status.SUCCESS -> {
                                    dataList.clear()
                                    dataList = this.data as MutableList<ArticlesModel>
                                    newsAdapter.notifyDataSetChanged()
                                }
                            }
                        }
                    })
                }

                override fun afterTextChanged(p0: Editable?) {

                }

            }

        }
    }

    override fun onClick(model: ArticlesModel, position: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("img",model.urlToImage)
        intent.putExtra("title",model.title)
        intent.putExtra("date",model.publishedAt)
        intent.putExtra("author",model.author)
        startActivity(intent)
    }
}