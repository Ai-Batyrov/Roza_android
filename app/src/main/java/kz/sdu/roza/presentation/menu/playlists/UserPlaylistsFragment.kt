package kz.sdu.roza.presentation.menu.playlists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.sdu.roza.R
import kz.sdu.roza.databinding.FragmentUserPlaylistsBinding

private const val userId = "1"

class UserPlaylistsFragment : Fragment() {
    private var userId: String? = null
    private var _binding: FragmentUserPlaylistsBinding? = null
    private val binding: FragmentUserPlaylistsBinding get() = _binding!!

    private val userPlaylistsViewModel: UserPlaylistsViewModel by viewModels(
        factoryProducer = { UserPlaylistsFactory(requireContext()) }
    )

    private lateinit var userPlaylists: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userId = it.getString(userId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserPlaylistsBinding.inflate(inflater, container, false)

        userPlaylists = binding.userPlaylistsRecyclerView
        userPlaylists.layoutManager = GridLayoutManager(context, 2)

        userPlaylistsViewModel.getPlaylists()
        userPlaylistsViewModel.playlist.observe(viewLifecycleOwner) {
            userPlaylists.adapter = UserPlaylistsAdapter(it)
        }
        userPlaylists.setHasFixedSize(true)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(userId: Int) =
            UserPlaylistsFragment().apply {
                arguments = Bundle().apply {
                    putString(userId.toString(), userId.toString())
                }
            }
    }
}
