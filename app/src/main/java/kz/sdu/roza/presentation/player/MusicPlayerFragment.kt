package kz.sdu.roza.presentation.player

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import kz.sdu.roza.R
import kz.sdu.roza.databinding.FragmentMusicPlayerBinding
import java.util.concurrent.TimeUnit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "title"
private const val ARG_PARAM2 = "artists"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicPlayerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("DEPRECATION")
class MusicPlayerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var title: String? = null
    private var artists: String? = null

    private lateinit var binding: FragmentMusicPlayerBinding
    private var mediaPlayer: MediaPlayer? = null
    private var currentSong = mutableListOf(R.raw.music)

    private lateinit var playerPosition: TextView
    private lateinit var seekBar: SeekBar

    private lateinit var btRewind: ImageView
    private lateinit var btPlay: ImageView
    private lateinit var btForward: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_PARAM1)
            artists = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMusicPlayerBinding.inflate(inflater, container, false)
        btPlay = binding.playButton
        seekBar = binding.seekBar
        playerPosition = binding.playerPosition
        btForward = binding.forwardButton
        btRewind = binding.rewindButton

        controlSound(currentSong[0])

        binding.trackTitleTextView.text = title
        binding.trackArtistsTextView.text = artists
        return binding.root
    }

    private fun controlSound(id: Int) {
        btPlay.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this.context, id)
            initialiseSeekBar()
            if (!mediaPlayer!!.isPlaying) {
                mediaPlayer?.start()
                btPlay.setImageResource(R.drawable.ic_pause)
            } else {
                mediaPlayer?.pause()
                btPlay.setImageResource(R.drawable.ic_play)
            }
        }

        btForward.setOnClickListener {
            var currentPosition = mediaPlayer?.currentPosition
            if (mediaPlayer?.isPlaying == true && mediaPlayer?.duration != currentPosition) {
                currentPosition = currentPosition?.plus(5000)
                playerPosition.text = convertFormat(currentPosition!!.toLong())
                mediaPlayer?.seekTo(currentPosition!!)
            }
        }

        btRewind.setOnClickListener {
            var currentPosition = mediaPlayer?.currentPosition
            if (mediaPlayer?.isPlaying == true && currentPosition!! > 5000) {
                currentPosition = currentPosition?.minus(5000)
                playerPosition.text = convertFormat(currentPosition!!.toLong())
                mediaPlayer?.seekTo(currentPosition!!)
            }
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2) {
                    mediaPlayer?.seekTo(p1)
                }
                playerPosition.text = convertFormat(mediaPlayer?.currentPosition!!.toLong())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        mediaPlayer?.setOnCompletionListener {
            btPlay.setImageResource(R.drawable.ic_play)
        }
    }

    private fun convertFormat(currentPosition: Long): CharSequence? {
        return String.format(
            "%02d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(currentPosition),
            TimeUnit.MILLISECONDS.toSeconds(currentPosition) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentPosition))
        )
    }

    private fun initialiseSeekBar() {
        seekBar.max = mediaPlayer!!.duration

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                try {
                    seekBar.progress = mediaPlayer!!.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e: Exception) {
                    seekBar.progress = 0
                }
            }
        }, 0)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MusicPlayerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MusicPlayerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}