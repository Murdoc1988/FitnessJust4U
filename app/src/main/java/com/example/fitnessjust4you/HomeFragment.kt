package com.example.fitnessjust4you

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.fitnessjust4you.data.entities.BodyStats
import com.example.fitnessjust4you.data.entities.Chart
import com.example.fitnessjust4you.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
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
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Home"
        binding.homeDiagrammImg.load("https://image-charts.com/chart?chbr=20&chco=CFECF7%2C27c9c2&chd=a%3A10000%2C50000%2C60000%2C80000%2C40000%7C50000%2C60000%2C100000%2C40000%2C20000&chdl=N%7CN-1&chdlp=r&chl=10%7C50%7C60%7C80%7C40%7C50%7C60%7C100%7C40%7C20&chs=700x450&cht=bvs&chtt=Revenue%20per%20month&chxl=0%3A%7CJan%7CFev%7CMar%7CAvr%7CMay&chxs=1N%2AcUSD0sz%2A%2C000000%2C14&chxt=x%2Cy")

    }

}