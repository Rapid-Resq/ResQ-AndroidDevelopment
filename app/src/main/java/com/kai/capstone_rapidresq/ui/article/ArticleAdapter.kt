package com.kai.capstone_rapidresq.ui.article

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kai.capstone_rapidresq.data.local.Article
import com.kai.capstone_rapidresq.databinding.ListArticleBinding
import com.kai.capstone_rapidresq.ui.detail.DetailArticleActivity

class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ListViewHolder>() {

    private var listOfArticle = ArrayList<Article>()

    fun addArticleList(list: List<Article>) {
        this.listOfArticle.clear()
        this.listOfArticle.addAll(list)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private val binding: ListArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val itemNow = listOfArticle[position]

            Glide.with(itemView.context).load(itemNow.image).fitCenter().into(binding.ivArticle)

            binding.tvTitleArticle.text = itemNow.title

            binding.itemLayout.setOnClickListener {
                val intent = Intent(itemView.context, DetailArticleActivity::class.java)
                intent.putExtra("articleData", itemNow)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ListArticleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfArticle.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(position)
    }
}