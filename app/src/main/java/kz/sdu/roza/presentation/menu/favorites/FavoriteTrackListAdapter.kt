package kz.sdu.roza.presentation.menu.favorites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R

class FavoriteTrackListAdapter(
    private val dataset: List<>,
    private val context: Context
)
    : RecyclerView.Adapter<FavoriteTrackListAdapter.TrackViewHolder>() {


    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private var title: TextView
        private var artists: TextView

        init {
            title = itemView.findViewById(R.id.text_track_list_item_title)
            artists = itemView.findViewById(R.id.text_track_list_item_artists)
        }

        fun bind(title: String) {
            this.title.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorites_list_item, parent, false)

        return TrackViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
