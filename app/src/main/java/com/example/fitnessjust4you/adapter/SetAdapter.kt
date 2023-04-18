package com.example.fitnessjust4you.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessjust4you.R
import com.example.fitnessjust4you.data.entities.TrainingSet
import com.example.fitnessjust4you.databinding.ItemSetBinding

class SetAdapter(var trainingsSetList: List<TrainingSet>): RecyclerView.Adapter<SetAdapter.SetHolder>() {
    inner class SetHolder(val binding: ItemSetBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(trainingSet: TrainingSet){
            binding.setNameText.text = trainingSet.sname
            binding.setRepsText.text = trainingSet.srepsstart.toString() + " bis " +
                    ""+ trainingSet.srepsend.toString() + " reps"
            binding.setCounterText.text = trainingSet.ssets.toString() + " sets "
            binding.setCard.setOnClickListener {
                binding.root.findNavController().navigate(R.id.action_trainingSetFragment_to_trainingDetailFragment)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetHolder {
        val binding = ItemSetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SetHolder(binding)
    }

    override fun onBindViewHolder(holder: SetHolder, position: Int) {
        holder.bind(trainingsSetList.get(position))
    }

    override fun getItemCount(): Int {
        return trainingsSetList.size
    }
}