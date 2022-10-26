package com.caneryildirim.arduinoprojelervedersler.Adaptors

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.RecyclerProjeBinding


class ProjeViewAdapter(private var listener: ProjeViewAdapter.Listener, private var imageProjeList:ArrayList<Int>, private var projeNoList:ArrayList<String>, private var projeKonuList:ArrayList<String>): RecyclerView.Adapter<ProjeViewAdapter.ProjeHolder>() {
    private val colorsNew= arrayListOf<Int>(R.color.row_green,R.color.row_white)

    interface Listener{
        fun onItemClick(position: Int)
    }

    class ProjeHolder(var binding: RecyclerProjeBinding):RecyclerView.ViewHolder(binding.root) {

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjeHolder {
        val binding=RecyclerProjeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProjeViewAdapter.ProjeHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjeHolder, position: Int) {
        holder.itemView.setBackgroundColor(holder.itemView.resources.getColor(colorsNew[position%2]))
        holder.binding.imageViewProje.setImageResource(imageProjeList[position])
        holder.binding.textViewProjeNo.text=projeNoList[position]
        holder.binding.textViewKonuProje.text=projeKonuList[position]
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return projeNoList.size
    }
}