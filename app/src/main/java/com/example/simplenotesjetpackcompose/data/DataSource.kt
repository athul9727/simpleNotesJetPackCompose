package com.example.simplenotesjetpackcompose.data

import com.example.simplenotesjetpackcompose.model.NoteModelEntity

class DataSource {
    fun getNote() = listOf<NoteModelEntity>(
        NoteModelEntity(title = "wqwq", notes = "asdsasasasa"),
        NoteModelEntity(title = "wqwq", notes = "asdsasasasa"),
        NoteModelEntity(title = "wqwq", notes = "asdsasasasa"),
        NoteModelEntity(title = "wqwq", notes = "asdsasasasa"),
        NoteModelEntity(title = "wqwq", notes = "asdsasasasa"),
        NoteModelEntity(title = "wqwq", notes = "asdsasasasa")
    )
}