package bimbetov.com.example.charity.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import bimbetov.com.example.charity.databinding.FundInfoBinding
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FundInfoActivity : AppCompatActivity() {

    lateinit var binding: FundInfoBinding

    private val FUND_KEY = "Fund"
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FundInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var donatAmount = 0

        val fundId = intent.getIntExtra("ID", 0)
        binding.fundNameTextView.text = intent.getStringExtra("FUND_NAME")
        var fundImg = intent.getStringExtra("FUND_IMG").toString()
        binding.cityTextView.text = intent.getStringExtra("CITY")
        binding.titleProblem.text = intent.getStringExtra("TITLE_PROBLEM")
        binding.fullInfo.text = intent.getStringExtra("DESCRIPTION_PROBLEM")

        binding.collectedAmount.text = intent.getIntExtra("COLLECTED_AMOUNT", 0).toString()
        binding.neededAmount.text = intent.getIntExtra("NEEDED_AMOUNT", 0).toString()

        if(binding.collectedAmount.text.toString().toInt() >= binding.neededAmount.text.toString().toInt()){
            binding.bottomLayout.visibility = View.GONE
            binding.availabilityTV.visibility = View.VISIBLE
            binding.donatAmount.visibility = View.INVISIBLE
        }

        var imgList = intent.getStringArrayExtra("IMAGE_INFO") as Array<String>
        //var needsImg = intent.getStringExtra("IMAGE_INFO").toString()

        Glide
            .with(this)
            .load(fundImg)
            .centerCrop()
            .into(binding.fundImageView)

        Glide
            .with(this)
            //.load(needsImg)
            .load(imgList[0])
            .centerCrop()
            .into(binding.imgNeedy)

        binding.helpBtnFromInfo.setOnClickListener {

            /*val myDialogFragment = MyDialogFragment()
            val manger = supportFragmentManager
            myDialogFragment.show(manger, "myDialog")*/


            if (binding.donatAmount.text.toString().isNotEmpty()) {
                donatAmount = binding.donatAmount.text.toString().toInt()

                Log.i("Tag", donatAmount.toString())
                val sum = donatAmount + binding.collectedAmount.text.toString().toInt()
                Log.i("Tag", sum.toString())

                mDatabase = FirebaseDatabase.getInstance().getReference(FUND_KEY)
                mDatabase.child(fundId.toString()).child("collectedAmount").setValue(sum)
                Toast.makeText(this,"?????????????? ???? ????????????", Toast.LENGTH_LONG).show()

                if(sum >= binding.neededAmount.text.toString().toInt()){
                    Toast.makeText(this,"???????????? ?????????? ??????????????, ??????????????!", Toast.LENGTH_LONG).show()
                    mDatabase.child(fundId.toString()).child("collectionAvailability").setValue("???????? ????????????")
                    //binding.bottomLayout.visibility = View.GONE
                    //binding.availabilityTV.visibility = View.VISIBLE
                }
                //checkForAvailabilityOfCollection(fundId)

                val intent = Intent(this, MainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)

            } else {
                Toast.makeText(this,"???? ???? ?????????? ??????????", Toast.LENGTH_LONG).show()
                binding.donatAmount.requestFocus()
            }

        }


    }

    private fun checkForAvailabilityOfCollection(id: Int) {

    }
}