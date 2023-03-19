package com.boldcomp.lokoi.activities

import androidx.appcompat.app.AppCompatActivity
import com.boldcomp.lokoi.R
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

class FullContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_content)

        supportActionBar?.title ="Back"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val url = intent.getStringExtra("url")
        if (url != null) {
            GlobalScope.launch {
                val doc = Jsoup.connect(url).get()
                val contentElement = doc.select("div[itemprop=articleBody]").firstOrNull()
                val expandedContent = contentElement?.text()
                runOnUiThread {
                    val contentTextView = findViewById<TextView>(R.id.contentTextView)
                    contentTextView.text = expandedContent
                }
            }

        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}