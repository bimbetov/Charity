package bimbetov.com.example.charity.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bimbetov.com.example.charity.R
import bimbetov.com.example.charity.model.Fund

class FundAdapter(private val item: List<Fund>) : RecyclerView.Adapter<FundViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FundViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return FundViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FundViewHolder, position: Int) {
        holder.setInfo(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }
}