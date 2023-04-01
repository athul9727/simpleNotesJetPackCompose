package com.example.simplenotesjetpackcompose.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.simplenotesjetpackcompose.data.DataSource
import com.example.simplenotesjetpackcompose.model.NoteModelEntity

class NoteViewModel : ViewModel() {

    val list = mutableStateListOf<NoteModelEntity>()

    init {
        list.addAll(DataSource().getNote())
    }

    fun addNote(note:NoteModelEntity){
       list.add(note)
    }

    fun removeNote(note:NoteModelEntity){
        list.remove(note)
    }

    fun getAllNote():List<NoteModelEntity>{
        return list
    }

}