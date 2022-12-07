package kz.sdu.roza.data.dao

import androidx.room.*
import kz.sdu.roza.data.entities.User

@Dao
interface UserDAO {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users WHERE userId = :key")
    fun get(key: Long): User?
}
