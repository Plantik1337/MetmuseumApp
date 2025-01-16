package com.example.metmuseumapp.presenter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.bumptech.glide.Glide
import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val id =  436535
    }

    private val viewModel: ObjectViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchObjectInfo(id)

        viewModel.currentObjectLiveData.observe(this) { objectInfo ->
            dataInteractor(objectInfo)
        }

    }

    private fun dataInteractor(objectInfo: ObjectInfo) {
        binding.progressBar.isGone = true

        Glide.with(binding.imageView)
            .load(objectInfo.primaryImage)
            .into(binding.imageView)

        binding.titleTV.isGone = false
        binding.dateTV.isGone = false

        binding.titleTV.text = objectInfo.title
        binding.dateTV.text = "${objectInfo.objectBeginDate} - ${objectInfo.objectEndDate}"

        if (objectInfo.artistRole.isNotEmpty()) {
            binding.artistRole.isGone = false
            binding.artistRoleTV.text = objectInfo.artistRole
            binding.artistRoleTV.isGone = false
        }

        if (objectInfo.artistDisplayName.isNotEmpty()) {
            binding.artistTitle.isGone = false
            binding.artistTV.text = objectInfo.artistDisplayName
            binding.artistTV.isGone = false
        }

        if (objectInfo.artistDisplayBio.isNotEmpty()) {
            binding.artistBio.isGone = false
            binding.artistBioTV.text = objectInfo.artistDisplayBio
            binding.artistBioTV.isGone = false
        }

        if (objectInfo.department.isNotEmpty()) {
            binding.departmentTitle.isGone = false
            binding.departmentTV.text = objectInfo.department
            binding.departmentTV.isGone = false
        }

        if (objectInfo.culture.isNotEmpty()) {
            binding.cultureTitle.isGone = false
            binding.cultureTV.text = objectInfo.culture
            binding.cultureTV.isGone = false
        }

        if (objectInfo.period.isNotEmpty()) {
            binding.periodTitle.isGone = false
            binding.periodTV.text = objectInfo.period
            binding.periodTV.isGone = false
        }

        if (objectInfo.medium.isNotEmpty()) {
            binding.mediumTitle.isGone = false
            binding.mediumTV.text = objectInfo.medium
            binding.mediumTV.isGone = false
        }

        if (objectInfo.dimensions.isNotEmpty()) {
            binding.dimensionsTitle.isGone = false
            binding.dimensionsTV.text = objectInfo.dimensions
            binding.dimensionsTV.isGone = false
        }
    }


}