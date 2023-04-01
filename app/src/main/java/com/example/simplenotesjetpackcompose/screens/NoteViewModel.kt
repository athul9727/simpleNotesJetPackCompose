package com.example.simplenotesjetpackcompose.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenotesjetpackcompose.data.DataSource
import com.example.simplenotesjetpackcompose.data.NoteDao
import com.example.simplenotesjetpackcompose.model.NoteModelEntity
import com.example.simplenotesjetpackcompose.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    private val _list: MutableStateFlow<List<NoteModelEntity>> = MutableStateFlow(listOf())
    val noteList = _list.asStateFlow()

    init {

        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect {
                if (it.isNotEmpty()) {
                    _list.value = it
                }
            }
        }

    }

     fun addNote(note: NoteModelEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.addNote(note)
        }


     fun removeNote(note: NoteModelEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.removeNote(note)
        }

     fun updateNote(note: NoteModelEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.updateNote(note)
        }

}