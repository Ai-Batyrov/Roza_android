package kz.sdu.roza.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kz.sdu.roza.data.dao.TrackDatabaseDAO
import kz.sdu.roza.data.dao.UserDAO
import kz.sdu.roza.data.entities.*

@Database(
    entities = [
        User::class,
        Track::class,
        Chart::class,
        Playlists::class,
        RadioStation::class,
        Album::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AudioServiceDatabase : RoomDatabase() {

    abstract val tracksDatabaseDao: TrackDatabaseDAO
    abstract val userDao: UserDAO

    companion object {
        @Volatile
        private var INSTANCE: AudioServiceDatabase? = null

        fun getInstance(context: Context): AudioServiceDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AudioServiceDatabase::class.java,
                        "audio_service_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
