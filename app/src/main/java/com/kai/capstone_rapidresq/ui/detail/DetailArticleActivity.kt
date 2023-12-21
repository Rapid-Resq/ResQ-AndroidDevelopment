package com.kai.capstone_rapidresq.ui.detail

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kai.capstone_rapidresq.data.local.Article
import com.kai.capstone_rapidresq.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailArticleBinding
    private lateinit var articleData: Article
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        articleData = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra("articleData", Article::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("articleData")!!
        }

        binding.tvTitle.text = articleData.title
        binding.tvLocation.text = articleData.location
        binding.tvArticleDetail.text = articleData.description
        Glide.with(this).load(articleData.image).fitCenter().into(binding.ivArticleDetail)
    }

    @Suppress("DEPRECATION")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}