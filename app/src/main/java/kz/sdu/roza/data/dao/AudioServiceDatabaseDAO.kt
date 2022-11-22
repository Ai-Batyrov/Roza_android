package kz.sdu.roza.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kz.sdu.roza.data.entities.Track

@Dao
interface TrackDatabaseDAO {

    @Insert
    fun insert(track: Track)

    @Update
    fun update(track: Track)

    @Delete
    fun delete(track: Track)

    @Query("SELECT * FROM TRACKS WHERE ID = :key")
    fun get(key: Long): Track?
}
