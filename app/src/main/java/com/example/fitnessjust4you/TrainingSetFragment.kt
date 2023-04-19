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
import com.example.fitnessjust4you.adapter.SetAdapter
import com.example.fitnessjust4you.data.entities.TrainingSet
import com.example.fitnessjust4you.databinding.FragmentTrainingSetBinding

class TrainingSetFragment : Fragment() {

    private var _binding: FragmentTrainingSetBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentTrainingSetBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Excercises"
        viewModel.setList.observe(viewLifecycleOwner){
            var adapter = SetAdapter(viewModel.setList.value!!)
            binding.setRecyclerview.adapter = adapter
        }

        binding.setoverlayCardview.isGone = true

        binding.setAddFAB.setOnClickListener {
            binding.setoverlayCardview.isVisible = true
            binding.setAddFAB.isGone = true
        }

        binding.setoverlayCancelButton.setOnClickListener {
            binding.setoverlayCardview.isGone = true
            binding.setAddFAB.isVisible = true
        }

        binding.setoverlayAddButton.setOnClickListener {

            var exercisename = binding.setNameInput.text.toString()
            var newSet = TrainingSet(0, exercisename, "Beugen mit den Beinen", (0..10).random(), (0..10).random(), (10..20).random(), "Waden", "Waden, Waden, Waden", 0,0  )

            viewModel.addSet(newSet)

            binding.setoverlayCardview.isGone = true
            binding.setAddFAB.isVisible = true

            binding.setNameInput.setText("")

            val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}