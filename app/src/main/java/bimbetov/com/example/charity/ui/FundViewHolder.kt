package bimbetov.com.example.charity.ui

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bimbetov.com.example.charity.R
import bimbetov.com.example.charity.databinding.ItemViewBinding
import bimbetov.com.example.charity.model.Fund
import com.bumptech.glide.Glide

//import kotlinx.android.synthetic.main.item_view.view.*

//class FundViewHolder(view: View) : RecyclerView.ViewHolder(view){
class FundViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){

    //lateinit var binding: ItemViewBinding

    /*var fundName: TextView? = null
    var fundImg: ImageView? = null
    var needAmount: TextView? = null
    var collectedAmount: TextView? = null

    init {
        fundName = itemView.findViewById(R.id.fundNameTextView)
        fundImg = itemView.findViewById(R.id.fundImageView)
        needAmount = itemView.findViewById(R.id.needCountTextView)
        collectedAmount = itemView.findViewById(R.id.collectedCountTextView)
    }*/

    fun setInfo(fund: Fund, c: Context){
        binding.fundNameTextView.text = fund.getFundName()
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
            .load(fund.getImgList()[0])
            .centerCrop()
            .into(binding.imagesInfo)
     /*fundName?.text = fund.getFundName()
        needAmount?.text = fund.getNeedAmount().toString()
        collectedAmount?.text = fund.getCollectedAmount().toString()*/
    }


}