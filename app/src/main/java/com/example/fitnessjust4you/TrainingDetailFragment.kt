package com.example.fitnessjust4you

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isGone
import androidx.core.view.isVisible
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

        binding.detailoverlayCardview.isGone = true

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

        binding.detailFAB.setOnClickListener {
            binding.detailoverlayCardview.isVisible = true
            binding.detailFAB.isGone = true
        }

        binding.detailoverlayCancelButton.setOnClickListener {
            binding.detailoverlayCardview.isGone = true
            binding.detailFAB.isVisible = true
        }

        binding.detailoverlayAddButton.setOnClickListener {

            var dweight = binding.detailoverlayWeightInput.text.toString().toDouble()
            binding.detailoverlayWeightInput.setText("")
            var dreps = binding.deatailoverlayRepsInput.text.toString().toInt()
            binding.deatailoverlayRepsInput.setText("")
            var dbreakmin = binding.detailoverlayMinInput.text.toString().toInt()
            binding.detailoverlayMinInput.setText("")
            var dbreaksec = binding.detailoverlaySecInput.text.toString().toInt()
            binding.detailoverlaySecInput.setText("")
            var newDetail = TrainingDetail(0,6,dweight, dreps, dbreakmin,dbreaksec, 0)

            viewModel.addDetail(newDetail)

            val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

            binding.detailoverlayCardview.isGone = true
            binding.detailFAB.isVisible = true
        }








    }

}