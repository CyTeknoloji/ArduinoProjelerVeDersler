package com.caneryildirim.arduinoprojelervedersler.Adaptors

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.RecyclerRowBinding


class DersViewAdaptor(private var listener:Listener, private var imageDersList:ArrayList<Int>, private var dersNoList:ArrayList<String>, private var dersKonuList:ArrayList<String>):RecyclerView.Adapter<DersViewAdaptor.DersHolder>() {
    private val colors= arrayListOf<String>("#FFFFFF","#aee3e2")
    interface Listener{
        fun onItemClick(position: Int)
    }

    class DersHolder(var binding:RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DersHolder {
        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DersHolder(binding)
    }

    override fun onBindViewHolder(holder: DersHolder, position: Int) {
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position %2]))
        holder.binding.imageViewProje.setImageResource(imageDersList[position])
        holder.binding.textViewProjeNo.text=dersNoList[position]
        holder.binding.textViewKonuProje.text=dersKonuList[position]
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return dersNoList.size
    }
}