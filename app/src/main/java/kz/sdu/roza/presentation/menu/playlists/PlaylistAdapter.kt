package kz.sdu.roza.presentation.menu.playlists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.models.Track

class PlaylistAdapter(private val dataSet: List<Track>) : RecyclerView.Adapter<PlaylistAdapter.TrackViewHolder>() {

    class TrackViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.text_track_list_item_title)
        private val artists: TextView = itemView.findViewById(R.id.text_track_list_item_artists)

        fun bind(title: String, artists: String) {
            this.title.text = title
            this.artists.text = artists
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorites_list_item, parent, false)
        return TrackViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item.title, item.artists)
    }

    override fun getItemCount(): Int = dataSet.size
}