package kz.sdu.roza.presentation.menu.playlists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.entities.Track

class SingleUserPlaylistAdapter(private val dataset: List<Track>) :
    RecyclerView.Adapter<SingleUserPlaylistAdapter.SingleUserPlaylistViewHolder>() {
    class SingleUserPlaylistViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private var title: TextView = item.findViewById(R.id.text_track_list_item_title)
        private var artists: TextView = itemView.findViewById(R.id.text_track_list_item_artists)

        fun bind(track: Track) {
            this.title.text = track.title
            this.artists.text = track.artists
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SingleUserPlaylistViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)

        return SingleUserPlaylistViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: SingleUserPlaylistViewHolder, position: Int) {
        val item: Track = dataset[position]

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("id", item.id.toInt())
            bundle.putString("title", item.title)

            holder.itemView.findNavController()
                .navigate(R.id.action_userPlaylistsFragment_to_singleUserPlaylistFragment, bundle)

            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = dataset.size
}
