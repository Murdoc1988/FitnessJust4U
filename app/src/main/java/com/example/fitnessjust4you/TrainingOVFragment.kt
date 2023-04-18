package com.example.fitnessjust4you

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fitnessjust4you.adapter.TrainingAdapter
import com.example.fitnessjust4you.data.entities.Training
import com.example.fitnessjust4you.data.entities.TrainingSet
import com.example.fitnessjust4you.databinding.FragmentTrainingOVBinding

class TrainingOVFragment : Fragment() {
    private var _binding: FragmentTrainingOVBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var newTraining = Training(0, "Bauch, Beine, Po")
        viewModel.addTraining(newTraining)
        newTraining = Training(0, "Rücken")
        viewModel.addTraining(newTraining)
        newTraining = Training(0, "Nacken, Oberarme")
        viewModel.addTraining(newTraining)
        newTraining = Training(0, "Bauch, Rücken")
        viewModel.addTraining(newTraining)

        var newSet = TrainingSet(0, "Beinbeuger", "Beugen mit den Beinen", 5, 8, 12, "Waden", "Waden, Waden, Waden", 0,0  )
        viewModel.addSet(newSet)
        newSet = TrainingSet(0, "Butterfly", "Händeklatschen für Grobmotoriker", 8, 10, 15, "Bizeps", "irgendwelche anderen Muskeln", 0,0  )
        viewModel.addSet(newSet)
        newSet = TrainingSet(0, "Bankdrücken", "Bank gegen den Boden drücken", 20, 5, 7, "Wandmuskel", "noch mal andere Muskeln", 0,0  )
        viewModel.addSet(newSet)
        newSet = TrainingSet(0, "Seilspringen", "Bring das Seil zum Springen", 2, 100, 150, "Keine", "Sieht nur doof aus", 0,0  )
        viewModel.addSet(newSet)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentTrainingOVBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Training"
        viewModel.trainingList.observe(viewLifecycleOwner){
            var adapter = TrainingAdapter(viewModel.trainingList.value!!)
            binding.trainingRecyclerview.adapter = adapter
        }
    }

}