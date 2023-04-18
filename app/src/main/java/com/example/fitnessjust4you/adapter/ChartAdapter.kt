package com.example.fitnessjust4you.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fitnessjust4you.data.entities.Chart
import com.example.fitnessjust4you.databinding.ItemChartBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class ChartAdapter(var chartList: List<Chart>): RecyclerView.Adapter<ChartAdapter.ChartHolder>() {

    inner class ChartHolder(val binding: ItemChartBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(chart: Chart){
            binding.chartImageview.load(chart.chart)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartHolder {

        val binding = ItemChartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChartHolder(binding)
    }

    override fun onBindViewHolder(holder: ChartHolder, position: Int) {
        holder.bind(chartList.get(position))
    }

    override fun getItemCount(): Int {
        return chartList.size
    }
    fun setData(chart: List<Chart>){
        this.chartList = chart
        notifyDataSetChanged()
    }

}