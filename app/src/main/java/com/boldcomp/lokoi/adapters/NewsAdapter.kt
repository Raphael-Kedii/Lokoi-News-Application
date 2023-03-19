package com.boldcomp.lokoi.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.boldcomp.lokoi.R
import com.boldcomp.lokoi.models.NewsArticle
import coil.load
import com.boldcomp.lokoi.activities.FullContentActivity



class NewsAdapter(var articles: List<NewsArticle>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
        holder.authorTextView.text = article.author
        holder.titleTextView.text = article.title
        holder.descriptionTextView.text = article.description
        holder.imageView.load(article.urlToImage)
        holder.publishedTextView.text = article.publishedAt

        holder.readMoreButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, FullContentActivity::class.java)
            intent.putExtra("url", article.url)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val publishedTextView: TextView = itemView.findViewById(R.id.publishedTextView)
        val readMoreButton: Button = itemView.findViewById(R.id.readMoreButton)

        fun bind(article: NewsArticle) {
            // ...
        }



    }
}