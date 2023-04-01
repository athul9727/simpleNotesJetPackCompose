package com.example.simplenotesjetpackcompose.repository

import com.example.simplenotesjetpackcompose.data.NoteDao
import com.example.simplenotesjetpackcompose.model.NoteModelEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class NoteRepository @Inject constructor (
    private val noteDao: NoteDao,
    ) {

   suspend fun addNote(note:NoteModelEntity){
     noteDao.addNote(note = note)
   }

    suspend fun removeNote(note:NoteModelEntity){
        noteDao.deleteNote(note = note)
    }

    suspend fun updateNote(note:NoteModelEntity){
        noteDao.updateNote(note = note)
    }

    fun getAllNotes(): Flow<List<NoteModelEntity>> {
       return noteDao.getAllNotes().flowOn(Dispatchers.IO).conflate()
    }

}