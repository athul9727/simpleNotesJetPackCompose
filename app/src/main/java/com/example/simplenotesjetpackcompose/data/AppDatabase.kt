package com.example.simplenotesjetpackcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplenotesjetpackcompose.model.NoteModelEntity

@Database(entities = [NoteModelEntity::class], version = 1, exportSchema = false)
abstract  class AppDatabase : RoomDatabase() {

   abstract fun noteDao(): NoteDao

}