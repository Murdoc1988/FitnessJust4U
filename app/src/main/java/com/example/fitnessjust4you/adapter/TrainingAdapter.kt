package com.example.fitnessjust4you.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessjust4you.R
import com.example.fitnessjust4you.data.entities.Training
import com.example.fitnessjust4you.databinding.ItemChartBinding
import com.example.fitnessjust4you.databinding.ItemOVBinding

class TrainingAdapter(var trainingList: List<Training>): RecyclerView.Adapter<TrainingAdapter.TrainingHolder>() {
    inner class TrainingHolder(val binding: ItemOVBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(training: Training){
            binding.trainingNameText.text = training.tname
            binding.trainingSetCounterText.text = (1..20).random().toString() + " Übungen"
            binding.trainingDurationText.text = (1..240).random().toString() + " min"
            binding.oVCard.setOnClickListener {
                binding.root.findNavController().navigate(R.id.action_trainingOVFragment_to_trainingSetFragment)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingHolder {
        val binding = ItemOVBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrainingHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainingHolder, position: Int) {
        holder.bind(trainingList.get(position))
    }

    override fun getItemCount(): Int {
        return trainingList.size
    }
}