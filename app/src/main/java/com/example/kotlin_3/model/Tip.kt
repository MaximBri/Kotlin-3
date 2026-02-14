package com.example.kotlin_3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    val dayNumber: Int,
    @param:StringRes val titleResId: Int,
    @param:DrawableRes val imageResId: Int,
    @param:StringRes val shortDescriptionResId: Int,
    @param:StringRes val fullDescriptionResId: Int
)
