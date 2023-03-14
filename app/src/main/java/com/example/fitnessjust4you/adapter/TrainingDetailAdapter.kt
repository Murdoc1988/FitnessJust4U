package com.example.fitnessjust4you.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessjust4you.databinding.ItemDetailFoldedBinding
import com.example.fitnessjust4you.model.TrainingDetail

class TrainingDetailAdapter (var trainingDetailList: MutableList<TrainingDetail>): RecyclerView.Adapter<TrainingDetailAdapter.DetailHolder>(){

    inner class DetailHolder(val binding: ItemDetailFoldedBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(trainingDetail: TrainingDetail){
            binding.detailCounterText.text = trainingDetail.dset.toString()
            binding.detailWeightText.text = trainingDetail.dweight.toString()
            binding.detailRepsText.text = trainingDetail.dreps.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailHolder {
        val binding = ItemDetailFoldedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailHolder, position: Int) {
        holder.bind(trainingDetailList.get(position))
    }

    override fun getItemCount(): Int {
        return trainingDetailList.size
    }
}