package kz.sdu.roza.presentation.menu.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.entities.Track

class SearchResultsAdapter(
    private val dataset: List<Track>
) : RecyclerView.Adapter<SearchResultsAdapter.ResultTrackViewHolder>() {

    class ResultTrackViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private var title: TextView = view.findViewById(R.id.text_track_list_item_title)
        private var artists: TextView = view.findViewById(R.id.text_track_list_item_artists)

        fun bind(track: Track) {
            this.title.text = track.title
            this.artists.text = track.artists
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultTrackViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorites_list_item, parent, false)

        return ResultTrackViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ResultTrackViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size
}
