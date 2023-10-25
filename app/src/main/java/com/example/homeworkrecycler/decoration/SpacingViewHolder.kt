package com.example.homeworkrecycler.decoration

import android.view.View
import android.view.ViewGroup
import com.example.homeworkrecycler.databinding.ItemSpacingBinding

class SpacingViewHolder (override val binding: ItemSpacingBinding, private val height: Int) :
    BaseJobsViewHolder<ItemSpacingBinding, String>(binding) {
    override fun bindView(item: String) {
        binding.root.setHeight(height.dp)
    }
}

fun View.setHeight(height: Int) {
    val layoutParams = this.layoutParams as ViewGroup.LayoutParams
    layoutParams.height = height
    this.layoutParams = layoutParams
}