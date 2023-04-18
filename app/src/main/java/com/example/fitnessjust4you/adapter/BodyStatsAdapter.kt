package com.example.fitnessjust4you.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessjust4you.data.entities.BodyStats
import com.example.fitnessjust4you.databinding.ItemBodystatsBinding

class BodyStatsAdapter(var bodyStatsList: List<BodyStats>): RecyclerView.Adapter<BodyStatsAdapter.BodyStatsHolder>() {

    inner class BodyStatsHolder(val binding: ItemBodystatsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(bodyStats: BodyStats){
            binding.itembsWeightValueTextview.text = bodyStats.bweigt.toString()
            binding.itembsWaterValueTextview.text = bodyStats.bwater.toString()
            binding.itembsFatValueTextview.text = bodyStats.bfat.toString()
            binding.itembsDateValueTextview.text = bodyStats.btimestamp.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodyStatsHolder {

        val binding = ItemBodystatsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BodyStatsHolder(binding)
    }

    override fun onBindViewHolder(holder: BodyStatsHolder, position: Int) {
        holder.bind(bodyStatsList.get(position))
    }

    override fun getItemCount(): Int {
        return bodyStatsList.size
    }
}