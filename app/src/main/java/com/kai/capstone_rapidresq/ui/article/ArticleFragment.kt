package com.kai.capstone_rapidresq.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kai.capstone_rapidresq.data.local.DataArticle
import com.kai.capstone_rapidresq.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private lateinit var binding: FragmentArticleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleBinding.inflate(inflater, container, false)

        showArticleList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun showArticleList() {
        val articleAdapter = ArticleAdapter()
        binding.recycleViewArticle.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleViewArticle.adapter = articleAdapter

        articleAdapter.addArticleList(DataArticle.articleList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}