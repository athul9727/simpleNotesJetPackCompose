package com.example.simplenotesjetpackcompose.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.simplenotesjetpackcompose.model.NoteModelEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@Dao
interface NoteDao {

    @Query("select * from NoteTable")
    fun getAllNotes() : Flow<List<NoteModelEntity>>

    @Query("select * from NoteTable where id = :noteId")
    suspend fun getNoteById(noteId:String) : NoteModelEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note:NoteModelEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note:NoteModelEntity)

    @Delete()
    suspend fun deleteNote(note:NoteModelEntity)

    @Query("delete from NoteTable")
    suspend fun deleteAllNotes()

}
