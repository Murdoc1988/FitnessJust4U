package com.example.fitnessjust4you

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.fitnessjust4you.adapter.BodyStatsAdapter
import com.example.fitnessjust4you.data.entities.BodyStats
import com.example.fitnessjust4you.databinding.FragmentBodystatsBinding
import com.example.fitnessjust4you.databinding.ItemBodystatsBinding

class BodyStatsFragment : Fragment() {

    private var _binding: FragmentBodystatsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBodystatsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = "BodyStats"
        binding.bodyStatsAddOverlay.isGone = true
        viewModel.bodyStatsList.observe(viewLifecycleOwner){
            var adapter = BodyStatsAdapter(viewModel.bodyStatsList.value!!)
            binding.bodyStatsRecyclerview.adapter = adapter
        }

        binding.bodyStatsFAB.setOnClickListener{
            binding.bodyStatsAddOverlay.isVisible = true
        }

        binding.bsoverlayCancleButton.setOnClickListener {
            binding.bodyStatsAddOverlay.isGone = true
        }

        binding.bsoverlayAddButton.setOnClickListener{

            var weighttemp = (binding.bsoverlayWeightInput.text.toString())
            var weight: Double = weighttemp.toDouble()
            var fat: Double  = binding.bsoverlayFatInput.text.toString().toDouble()
            var water: Double  = binding.bsoverlayWaterInput.text.toString().toDouble()
            var bodyStats = BodyStats(0, "03.03.2023", weight, fat, water, 0 )
            viewModel.addBodyStats(bodyStats)

        }

    }
}