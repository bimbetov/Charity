package bimbetov.com.example.charity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bimbetov.com.example.charity.R
import bimbetov.com.example.charity.repository.FakeFundRepository
import bimbetov.com.example.charity.repository.FundRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository: FundRepository = FakeFundRepository()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FundAdapter(repository.getFund())

    }
}