package kz.sdu.roza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var trackList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trackList = findViewById(R.id.favorite_recycler_view)

        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        trackList.layoutManager = layoutManager
        trackList.setHasFixedSize(true)
    }
}
