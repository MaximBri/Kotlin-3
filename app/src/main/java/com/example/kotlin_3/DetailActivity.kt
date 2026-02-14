package com.example.kotlin_3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DAY_NUMBER = "extra_day_number"
        const val EXTRA_TITLE_RES_ID = "extra_title_res_id"
        const val EXTRA_IMAGE_RES_ID = "extra_image_res_id"
        const val EXTRA_FULL_DESC_RES_ID = "extra_full_desc_res_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<MaterialToolbar>(R.id.detailToolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { finish() }

        val dayNumber = intent.getIntExtra(EXTRA_DAY_NUMBER, 1)
        val titleResId = intent.getIntExtra(EXTRA_TITLE_RES_ID, R.string.app_name)
        val imageResId = intent.getIntExtra(EXTRA_IMAGE_RES_ID, R.drawable.picture1)
        val fullDescResId = intent.getIntExtra(EXTRA_FULL_DESC_RES_ID, R.string.tip_full_1)

        findViewById<TextView>(R.id.detailDayNumber).text =
            getString(R.string.day_label, dayNumber)
        findViewById<TextView>(R.id.detailTitle).text = getString(titleResId)

        val detailImage = findViewById<ImageView>(R.id.detailImage)
        detailImage.setImageResource(imageResId)
        detailImage.contentDescription = getString(titleResId)

        findViewById<TextView>(R.id.detailDescription).text = getString(fullDescResId)
    }
}
