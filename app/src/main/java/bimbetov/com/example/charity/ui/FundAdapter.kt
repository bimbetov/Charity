package bimbetov.com.example.charity.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import bimbetov.com.example.charity.R
import bimbetov.com.example.charity.databinding.ItemViewBinding
import bimbetov.com.example.charity.model.Fund



class FundAdapter(
    private val c: Context,
    private val item: List<Fund>
    ) : RecyclerView.Adapter<FundViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FundViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent,false)

        return FundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FundViewHolder, position: Int) {
        holder.setInfo(item[position], c)
        holder.binding.root.setOnClickListener {
            val intent = Intent(c, FundInfoActivity::class.java)
            c.startActivity(intent)
                /*putExtra(IMAGE_INFO, .getImage().toTypedArray())
                putExtra(NEEDED_AMOUNT, needy.getNeededAmount())
                putExtra(COLLECTED_AMOUNT, needy.getCollectedAmount())*/
        }
    }

    override fun getItemCount() = item.size

}