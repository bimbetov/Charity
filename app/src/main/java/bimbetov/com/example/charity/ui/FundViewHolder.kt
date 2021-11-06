package bimbetov.com.example.charity.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bimbetov.com.example.charity.R
import bimbetov.com.example.charity.model.Fund
//import kotlinx.android.synthetic.main.item_view.view.*

class FundViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var fundName: TextView? = null
    var fundImg: ImageView? = null
    var needAmount: TextView? = null
    var collectedAmount: TextView? = null

    init {
        fundName = itemView.findViewById(R.id.fundNameTextView)
        fundImg = itemView.findViewById(R.id.fundImageView)
        needAmount = itemView.findViewById(R.id.needCountTextView)
        collectedAmount = itemView.findViewById(R.id.collectedCountTextView)
    }

    fun setInfo(fund: Fund){
        fundName?.text = fund.getFundName()
        needAmount?.text = fund.getNeedAmount().toString()
        collectedAmount?.text = fund.getCollectedAmount().toString()
    }


}