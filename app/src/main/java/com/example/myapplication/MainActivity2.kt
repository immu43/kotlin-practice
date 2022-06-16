package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMain2Binding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    private var mAdapter: QuotesAdapter?= null;
    private var mQuotes: MutableList<Result> = ArrayList()


    @SuppressLint("NotifyDataSetChanged")
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val quotesApi = QuotesController.getInstance().create(QuoteApi::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        mAdapter = QuotesAdapter(this, mQuotes, R.layout.quote_row)
        binding.recyclerView.adapter = mAdapter


        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            mQuotes.addAll(result.body()?.results!!)
            mAdapter!!.notifyDataSetChanged()

        }
    }
}