package kz.sdu.roza.data.entities.converters

import androidx.room.TypeConverter
import java.sql.Date

class DateConverter {
    @TypeConverter
    fun toDate(timestamp: Long): Date {
        return Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date): Long {
        return date.time
    }
}
