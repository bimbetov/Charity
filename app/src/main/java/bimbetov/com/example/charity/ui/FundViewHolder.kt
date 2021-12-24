package bimbetov.com.example.charity.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import bimbetov.com.example.charity.databinding.ItemViewBinding
import bimbetov.com.example.charity.model.Fund
import com.bumptech.glide.Glide

class FundViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){

    fun setInfo(fund: Fund, c: Context){

        binding.fundNameTextView.text = fund.getFundName()
        binding.cityTextView.text = fund.getCity()
        binding.needCountTextView.text = fund.getNeedAmount().toString()
        binding.collectedCountTextView.text = fund.getCollectedAmount().toString()
        binding.titleTextView.text = fund.getTitleProblem()

        Glide
            .with(c)
            .load(fund.getFundImg())
            .centerCrop()
            .into(binding.fundImageView)

        Glide
            .with(c)
            //.load(fund.getNeedsImg())
            .load(fund.getImgList()[0])
            .centerCrop()
            .into(binding.imagesInfo)

        /*binding.helpButton.setOnClickListener {

        }*/
    }


}