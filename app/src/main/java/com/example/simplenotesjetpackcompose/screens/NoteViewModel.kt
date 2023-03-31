package com.example.simplenotesjetpackcompose.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.simplenotesjetpackcompose.data.DataSource
import com.example.simplenotesjetpackcompose.model.NoteModel

class NoteViewModel : ViewModel() {

    val list = mutableStateListOf<NoteModel>()

    init {
        list.addAll(DataSource().getNote())
    }

    fun addNote(note:NoteModel){
       list.add(note)
    }

    fun removeNote(note:NoteModel){
        list.remove(note)
    }

    fun getAllNote():List<NoteModel>{
        return list
    }

}