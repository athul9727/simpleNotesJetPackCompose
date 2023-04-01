package com.example.simplenotesjetpackcompose.data

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date: Date) : Long { return date.time }

    @TypeConverter
    fun dateFromTimeStamp(timStamp: Long) : Date { return Date(timStamp) }
}

class UUIDConverter {
    @TypeConverter
    fun stringFromUUID(uuid: UUID) : String { return uuid.toString() }

    @TypeConverter
    fun uuidFromString(string: String) : UUID { return UUID.fromString(string) }
}