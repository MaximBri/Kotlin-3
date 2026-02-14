package com.example.kotlin_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_3.adapter.TipAdapter
import com.example.kotlin_3.data.TipData
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TipAdapter(TipData.tips) { tip ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_DAY_NUMBER, tip.dayNumber)
                putExtra(DetailActivity.EXTRA_TITLE_RES_ID, tip.titleResId)
                putExtra(DetailActivity.EXTRA_IMAGE_RES_ID, tip.imageResId)
                putExtra(DetailActivity.EXTRA_FULL_DESC_RES_ID, tip.fullDescriptionResId)
            }
            startActivity(intent)
        }
    }
}
