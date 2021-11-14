package bimbetov.com.example.charity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bimbetov.com.example.charity.databinding.FundInfoBinding

class FundInfoActivity : AppCompatActivity() {

    lateinit var binding: FundInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FundInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}