package bimbetov.com.example.charity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bimbetov.com.example.charity.databinding.FundInfoBinding
import com.bumptech.glide.Glide

class FundInfoActivity : AppCompatActivity() {

    lateinit var binding: FundInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FundInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fundNameTextView.text = intent.getStringExtra("FUND_NAME")
        var fundImg = intent.getStringExtra("FUND_IMG").toString()
        binding.cityTextView.text = intent.getStringExtra("CITY")
        binding.titleProblem.text = intent.getStringExtra("TITLE_PROBLEM")
        binding.fullInfo.text = intent.getStringExtra("DESCRIPTION_PROBLEM")

        binding.collectedAmount.text = intent.getIntExtra("COLLECTED_AMOUNT", 0).toString()
        binding.neededAmount.text = intent.getIntExtra("NEEDED_AMOUNT", 0).toString()
        var imgList = intent.getStringArrayExtra("IMAGE_INFO") as Array<String>

        Glide
            .with(this)
            .load(fundImg)
            .centerCrop()
            .into(binding.fundImageView)

        Glide
            .with(this)
            .load(imgList[0])
            .centerCrop()
            .into(binding.imgNeedy)



    }
}