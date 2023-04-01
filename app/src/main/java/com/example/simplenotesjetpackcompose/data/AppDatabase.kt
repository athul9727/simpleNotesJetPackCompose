package com.example.simplenotesjetpackcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.simplenotesjetpackcompose.model.NoteModelEntity

@Database(entities = [NoteModelEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract  class AppDatabase : RoomDatabase() {

   abstract fun noteDao(): NoteDao

}