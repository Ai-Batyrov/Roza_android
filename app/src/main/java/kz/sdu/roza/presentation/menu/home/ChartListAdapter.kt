package kz.sdu.roza.presentation.menu.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.entities.Chart


class ChartListAdapter(
    private val dataSet: List<Chart>,
) :
    RecyclerView.Adapter<ChartListAdapter.ChartsListViewHolder>() {

    class ChartsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title: TextView = itemView.findViewById(R.id.card_title)
        private var desc: TextView = itemView.findViewById(R.id.card_desc)
        private var coverImage: ImageView = itemView.findViewById(R.id.card_cover_image)

        fun bind(chart: Chart) {
            this.title.text = chart.title
            this.desc.text = chart.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartsListViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)

        return ChartsListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ChartsListViewHolder, position: Int) {
        val item: Chart = dataSet[position]

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("id", item.id)
            bundle.putString("title", item.title)

            holder.itemView.findNavController()
                .navigate(R.id.action_homeMainFragment_to_chartFragment, bundle)
        }

        holder.bind(item)
    }

    override fun getItemCount(): Int = dataSet.size
}
