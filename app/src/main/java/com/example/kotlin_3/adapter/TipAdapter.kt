package com.example.kotlin_3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_3.R
import com.example.kotlin_3.model.Tip

class TipAdapter(
    private val tips: List<Tip>,
    private val onItemClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayNumber: TextView = itemView.findViewById(R.id.dayNumber)
        val tipTitle: TextView = itemView.findViewById(R.id.tipTitle)
        val tipImage: ImageView = itemView.findViewById(R.id.tipImage)
        val tipDescription: TextView = itemView.findViewById(R.id.tipDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        val context = holder.itemView.context

        holder.dayNumber.text = context.getString(R.string.day_label, tip.dayNumber)
        holder.tipTitle.text = context.getString(tip.titleResId)
        holder.tipImage.setImageResource(tip.imageResId)
        holder.tipImage.contentDescription = context.getString(tip.titleResId)
        holder.tipDescription.text = context.getString(tip.shortDescriptionResId)

        holder.itemView.setOnClickListener {
            onItemClick(tip)
        }
    }

    override fun getItemCount(): Int = tips.size
}
