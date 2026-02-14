package com.example.kotlin_3.data

import com.example.kotlin_3.R
import com.example.kotlin_3.model.Tip

object TipData {

    private val images = listOf(
        R.drawable.picture1,
        R.drawable.picture2,
        R.drawable.picture3,
        R.drawable.picture4,
        R.drawable.picture5
    )

    private val tipTitles = listOf(
        R.string.tip_title_1,
        R.string.tip_title_2,
        R.string.tip_title_3,
        R.string.tip_title_4,
        R.string.tip_title_5
    )

    private val tipShortDescriptions = listOf(
        R.string.tip_short_1,
        R.string.tip_short_2,
        R.string.tip_short_3,
        R.string.tip_short_4,
        R.string.tip_short_5
    )

    private val tipFullDescriptions = listOf(
        R.string.tip_full_1,
        R.string.tip_full_2,
        R.string.tip_full_3,
        R.string.tip_full_4,
        R.string.tip_full_5
    )

    private fun getIndexForDay(day: Int): Int = (day - 1) % 5

    val tips: List<Tip> = (1..30).map { day ->
        val index = getIndexForDay(day)
        Tip(
            dayNumber = day,
            titleResId = tipTitles[index],
            imageResId = images[index],
            shortDescriptionResId = tipShortDescriptions[index],
            fullDescriptionResId = tipFullDescriptions[index]
        )
    }
}
