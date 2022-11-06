package kz.sdu.roza.presentation.menu.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.models.Chart

class ChartListAdapter(private val dataSet: List<Chart>) :
    RecyclerView.Adapter<ChartListAdapter.ChartsListViewHolder>() {

    class ChartsListViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
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
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = dataSet.size
}
