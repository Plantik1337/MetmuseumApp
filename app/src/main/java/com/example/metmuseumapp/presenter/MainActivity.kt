package com.example.metmuseumapp.presenter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.bumptech.glide.Glide
import com.example.metmuseumapp.ObjectInfo
import com.example.metmuseumapp.R
import com.example.metmuseumapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ObjectViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchObjectInfo()

        viewModel.currentObjectLiveData.observe(this) { objectInfo ->
            showData(objectInfo)
        }

        binding.backButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.back), Toast.LENGTH_SHORT).show()
        }
        binding.expandButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.expand), Toast.LENGTH_SHORT).show()
        }
    }

    private fun showData(objectInfo: ObjectInfo) {
        binding.progressBar.isGone = true

        Glide.with(binding.imageView).load(objectInfo.primaryImage).into(binding.imageView)

        binding.titleTV.isGone = false
        binding.dateTV.isGone = false

        binding.titleTV.text = objectInfo.title
        binding.dateTV.text = buildString {
            append(objectInfo.objectBeginDate)
            append(" - ")
            append(objectInfo.objectEndDate)
        }

        binding.artistRole.setInfo(getString(R.string.artist_role), objectInfo.artistRole)
        binding.artist.setInfo(getString(R.string.artist), objectInfo.artistDisplayName)
        binding.artistBio.setInfo(getString(R.string.artist_bio), objectInfo.artistDisplayBio)
        binding.department.setInfo(getString(R.string.department), objectInfo.department)
        binding.culture.setInfo(getString(R.string.culture), objectInfo.culture)
        binding.period.setInfo(getString(R.string.period), objectInfo.period)
        binding.medium.setInfo(getString(R.string.medium), objectInfo.medium)
        binding.dimensions.setInfo(getString(R.string.dimensions), objectInfo.dimensions)

    }


}