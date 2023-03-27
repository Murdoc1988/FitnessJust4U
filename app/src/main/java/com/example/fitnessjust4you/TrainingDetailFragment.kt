package com.example.fitnessjust4you

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnessjust4you.adapter.TrainingDetailAdapter
import com.example.fitnessjust4you.databinding.FragmentTrainingDetailBinding
import com.example.fitnessjust4you.data.entities.TrainingDetail
class TrainingDetailFragment : Fragment() {

    private var trainingDetailList: MutableList<TrainingDetail> = mutableListOf(
        TrainingDetail(1, 1, 80.0, 20, 1, 30, 1),
        TrainingDetail(2, 2, 80.0, 20, 1, 30, 1),
        TrainingDetail(3, 3, 80.0, 20, 1, 30, 1),
        TrainingDetail(4, 4, 80.0, 20, 1, 30, 1),
        TrainingDetail(5, 1, 90.0, 20, 1, 30, 2),
        TrainingDetail(6, 2, 95.0, 20, 1, 30, 2),
        TrainingDetail(7, 3, 100.0, 20, 1, 30, 2),
        TrainingDetail(8, 4, 105.0, 20, 1, 30, 2),
        TrainingDetail(9, 5, 110.0, 20, 1, 30, 2),
        TrainingDetail(10, 6, 115.0, 20, 1, 30, 2),
        TrainingDetail(11, 1, 40.0, 12, 2, 0, 3),
        TrainingDetail(12, 2, 50.0, 10, 2, 0,3),
        TrainingDetail(13, 3, 60.0, 10, 2, 0, 3),
        TrainingDetail(14, 4, 70.0, 8, 2, 0, 3),
        TrainingDetail(15, 5, 80.0, 8, 2, 0, 3),
        TrainingDetail(16, 6, 80.0, 8, 2, 0, 3),
        TrainingDetail(17, 1, 100.0, 12, 1, 45, 4),
        TrainingDetail(18, 2, 120.0, 12, 1, 45, 4),
        TrainingDetail(19, 3, 120.0, 12, 1, 45, 4),
        TrainingDetail(20, 4, 100.0, 12, 1, 45, 4)
    )
    private var _binding: FragmentTrainingDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        _binding = FragmentTrainingDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    /*fun setUpUi(){
        binding.detailRv.layoutManager = LinearLayoutManager(this)
        adapter = TrainingDetailAdapter(trainingDetailList)
        binding.detailRv.adapter = adapter
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter =  TrainingDetailAdapter(trainingDetailList)
        binding.detailRv.adapter = adapter

        activity?.title = "Set Name"




    }

}