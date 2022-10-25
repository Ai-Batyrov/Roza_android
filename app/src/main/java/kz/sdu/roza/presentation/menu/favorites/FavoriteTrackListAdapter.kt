package kz.sdu.roza.presentation.menu.favorites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.models.Track

class FavoriteTrackListAdapter(
    private val dataset: List<Track>
)
    : RecyclerView.Adapter<FavoriteTrackListAdapter.TrackViewHolder>() {


    class TrackViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private var title: TextView = itemView.findViewById(R.id.text_track_list_item_title)
        private var artists: TextView = itemView.findViewById(R.id.text_track_list_item_artists)

        fun bind(title: String, artists: String) {
            this.artists.text = artists
            this.title.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorites_list_item, parent, false)

        return TrackViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item.title, item.artists)
    }

    override fun getItemCount(): Int = dataset.size
}
