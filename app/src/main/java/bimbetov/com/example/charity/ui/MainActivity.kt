package bimbetov.com.example.charity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bimbetov.com.example.charity.R
import bimbetov.com.example.charity.databinding.ActivityMainBinding
import bimbetov.com.example.charity.repository.FakeFundRepository
import bimbetov.com.example.charity.repository.FundRepository

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository: FundRepository = FakeFundRepository()

        with(binding.recyclerView){
            layoutManager = LinearLayoutManager(context)
            adapter =FundAdapter(context, repository.getFund())
        }

    }
}