package com.example.metmuseumapp.presenter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.metmuseumapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: ObjectViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchObjectInfo(436535)


        viewModel.currentObjectLiveData.observe(this) { objectInfo ->
            Glide.with(binding.imageView)
                .load(objectInfo.primaryImage)
                .into(binding.imageView)

            binding.titleTV.text = objectInfo.title
            binding.dateTV.text = "${objectInfo.objectBeginDate} - ${objectInfo.objectEndDate}"

            binding.artistTV.text = "${objectInfo.artistDisplayName}, ${objectInfo.artistRole}"

            binding.departmentTV.text = "${objectInfo.department}, ${objectInfo.culture}"

            binding.mediumTV.text = "${objectInfo.medium}"

            binding.dimensionsTV.text = "${objectInfo.dimensions}"

        }

    }
}