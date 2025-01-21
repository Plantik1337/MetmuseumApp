package com.example.metmuseumapp.presenter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isGone
import com.example.metmuseumapp.databinding.ViewInfoItemBinding

class InfoItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: ViewInfoItemBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = ViewInfoItemBinding.inflate(inflater, this)
        orientation = VERTICAL
    }

    fun setInfo(title: String, value: String?) {
        if (!value.isNullOrEmpty()) {
            binding.titleTV.text = title
            binding.titleTV.isGone = false
            binding.valueTV.text = value
            binding.valueTV.isGone = false
        } else {
            binding.titleTV.isGone = true
            binding.valueTV.isGone = true
        }
    }
}