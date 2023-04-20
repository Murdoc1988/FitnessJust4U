package com.example.fitnessjust4you

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.fitnessjust4you.adapter.TrainingAdapter
import com.example.fitnessjust4you.data.entities.Training
import com.example.fitnessjust4you.data.entities.TrainingDetail
import com.example.fitnessjust4you.data.entities.TrainingSet
import com.example.fitnessjust4you.databinding.FragmentTrainingOVBinding

class TrainingOVFragment : Fragment() {
    private var _binding: FragmentTrainingOVBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fillDatabase()

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
        activity?.title = "Trainings"
        viewModel.trainingList.observe(viewLifecycleOwner){
            var adapter = TrainingAdapter(viewModel.trainingList.value!!)
            binding.trainingRecyclerview.adapter = adapter
        }

        binding.trainingoverlayCardview.isGone = true

        binding.trainingoverlayFAB.setOnClickListener {
            binding.trainingoverlayFAB.isGone = true
            binding.trainingoverlayCardview.isVisible = true
        }

        binding.trainingoverlayCancelButton.setOnClickListener {
            binding.trainingoverlayCardview.isGone = true
            binding.trainingoverlayFAB.isVisible = true
        }

        binding.trainingoverlayAddButton.setOnClickListener {

            var trainingname = binding.trainingoverlayNameInput.text.toString()
            var newTraining = Training(0, trainingname)

            viewModel.addTraining(newTraining)

            binding.trainingoverlayCardview.isGone = true
            binding.trainingoverlayFAB.isVisible = true

            binding.trainingoverlayNameTextview.setText("")

            val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }


    private fun fillDatabase() {

        //erstes Training
        var newTraining = Training(0, "Bauch, Beine, Po")
        viewModel.addTraining(newTraining)

        newTraining = Training(0, "Rücken")
        viewModel.addTraining(newTraining)
        newTraining = Training(0, "Nacken, Oberarme")
        viewModel.addTraining(newTraining)
        newTraining = Training(0, "Bauch, Rücken")
        viewModel.addTraining(newTraining)

        //Sets zum ersten Training
        var newSet = TrainingSet(0, "Beinbeuger", "Beugen mit den Beinen", 5, 8, 12, "Waden", "Waden, Waden, Waden", 1,0  )
        viewModel.addSet(newSet)

        newSet = TrainingSet(0, "Butterfly", "Händeklatschen für Grobmotoriker", 5, 8, 12, "Waden", "Waden, Waden, Waden", 1,0  )
        viewModel.addSet(newSet)

        newSet = TrainingSet(0, "Bankdrücken", "Bank gegen den Boden drücken", 5, 8, 12, "Waden", "Waden, Waden, Waden",1 ,0  )
        viewModel.addSet(newSet)


        ////Sets zum zweiten Training
        newSet = TrainingSet(0, "Butterfly", "Butterfliege", 8, 10, 15, "Bizeps", "irgendwelche anderen Muskeln", 2,0  )
        viewModel.addSet(newSet)

        newSet = TrainingSet(0, "Bankdrücken", "Drücken gegen die Bank", 20, 5, 7, "Wandmuskel", "noch mal andere Muskeln", 2,0  )
        viewModel.addSet(newSet)

        newSet = TrainingSet(0, "Seilspringen", "Spring über das Seil!", 2, 100, 150, "Keine", "Sieht nur doof aus", 2,1  )
        viewModel.addSet(newSet)


        //Details zum ersten Set
        var newTrainingDetail =  TrainingDetail(1, 1, 80.0, 20, 1, 30, 1)
        viewModel.addDetail(newTrainingDetail)

        newTrainingDetail =  TrainingDetail(2, 2, 80.0, 20, 1, 30, 1)
        viewModel.addDetail(newTrainingDetail)

        //Details zum zweiten Set

        newTrainingDetail =  TrainingDetail(3, 1, 80.0, 20, 1, 30, 2)
        viewModel.addDetail(newTrainingDetail)

        newTrainingDetail =  TrainingDetail(4, 2, 80.0, 20, 1, 30, 2)
        viewModel.addDetail(newTrainingDetail)
    }

}