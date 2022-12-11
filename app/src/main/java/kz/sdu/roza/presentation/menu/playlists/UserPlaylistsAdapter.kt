package kz.sdu.roza.presentation.menu.playlists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.data.entities.Playlists

class UserPlaylistsAdapter(private val dataset: List<Playlists>) :
    RecyclerView.Adapter<UserPlaylistsAdapter.UserPlaylistViewHolder>() {

    class UserPlaylistViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private var title: TextView = item.findViewById(R.id.card_title)

        fun bind(playlist: Playlists) {
            this.title.text = playlist.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPlaylistViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)

        return UserPlaylistViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: UserPlaylistViewHolder, position: Int) {
        val item: Playlists = dataset[position]

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("id", item.id.toInt())
            bundle.putString("title", item.title)

            holder.itemView.findNavController()
                .navigate(R.id.action_homeMainFragment_to_chartFragment, bundle)

            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = dataset.size
}
