package kz.sdu.roza.presentation.menu.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.entities.Chart
import kz.sdu.roza.data.entities.Track

class SingleChartViewAdapter(private val dataSet: List<Track>) :
    RecyclerView.Adapter<SingleChartViewAdapter.ChartPlaylistItemViewHolder>() {

    class ChartPlaylistItemViewHolder(private val itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var title: TextView = itemView.findViewById(R.id.text_track_list_item_title)
        private var artists: TextView = itemView.findViewById(R.id.text_track_list_item_artists)

        fun bind(track: Track) {
            this.title.text = track.title
            this.artists.text = track.artists
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartPlaylistItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorites_list_item, parent, false)

        return ChartPlaylistItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ChartPlaylistItemViewHolder, position: Int) {
        val track: Track = dataSet[position]
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("artists", track.artists)
            bundle.putString("title", track.title)

            holder.itemView.findNavController()
                .navigate(R.id.action_chartFragment_to_musicPlayerFragment, bundle)
        }
        holder.bind(track)
    }

    override fun getItemCount(): Int = dataSet.size
}
