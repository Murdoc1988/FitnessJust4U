package com.example.fitnessjust4you

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fitnessjust4you.adapter.SetAdapter
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
        activity?.title = "Sets"
        viewModel.setList.observe(viewLifecycleOwner){
            var adapter = SetAdapter(viewModel.setList.value!!)
            binding.setRecyclerview.adapter = adapter
        }
    }
}