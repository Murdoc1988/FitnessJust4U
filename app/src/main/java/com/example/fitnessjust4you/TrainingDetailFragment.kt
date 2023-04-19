package com.example.fitnessjust4you

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fitnessjust4you.adapter.TrainingDetailAdapter
import com.example.fitnessjust4you.databinding.FragmentTrainingDetailBinding
import com.example.fitnessjust4you.data.entities.TrainingDetail
class TrainingDetailFragment : Fragment() {

    enum class TimerState{
        Stopped, Paused, Running
    }

    private var _binding: FragmentTrainingDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by activityViewModels()
    private lateinit var timer: CountDownTimer



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        _binding = FragmentTrainingDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Sets"

        viewModel.detailList.observe(viewLifecycleOwner){
            var adapter =  TrainingDetailAdapter(viewModel.detailList.value!!)
            binding.detailRv.adapter = adapter
        }
        binding.detailCountdownButton.setBackgroundColor(Color.GREEN)


        timer = object: CountDownTimer(90_000, 1_000){
            override fun onTick(millisUntilFinished: Long) {
                val sec = String.format("%02d",(millisUntilFinished / 1000) % 60)
                val min = String.format("%02d",(millisUntilFinished / (1000 * 60)) % 60)
                val formattedTimeStr = "$min : $sec"
                binding.detailCountdownButton.text = formattedTimeStr

            }

            override fun onFinish() {
                binding.detailCountdownButton.setBackgroundColor(Color.GREEN)
                binding.detailCountdownButton.text = "break"
            }
        }

        binding.detailCountdownButton.setOnClickListener {
            binding.detailCountdownButton.setBackgroundColor(Color.RED)
            timer.start()

        }






    }

}