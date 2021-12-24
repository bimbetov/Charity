package bimbetov.com.example.charity.ui

import android.content.ContentValues.TAG
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bimbetov.com.example.charity.R
import bimbetov.com.example.charity.databinding.ActivityMainBinding
import bimbetov.com.example.charity.model.Fund
import bimbetov.com.example.charity.repository.FakeFundRepository
import bimbetov.com.example.charity.repository.FundRepository
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val FUND_KEY = "Fund"
    private lateinit var mDatabase: DatabaseReference
    private var fundList = mutableListOf<Fund>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataFromDB()

        with(binding.recyclerView){
            layoutManager = LinearLayoutManager(context)
            adapter = FundAdapter(context, fundList)
        }

    }

    private fun getDataFromDB() {
        mDatabase = FirebaseDatabase.getInstance().getReference(FUND_KEY)

        mDatabase.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    for (itemSnapshot in snapshot.children){
                        val fund = itemSnapshot.getValue(Fund::class.java)
                        fundList.add(fund!!)
                    }
                    binding.recyclerView.adapter!!.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}