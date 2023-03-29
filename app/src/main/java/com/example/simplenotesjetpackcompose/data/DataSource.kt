package com.example.simplenotesjetpackcompose.data

import com.example.simplenotesjetpackcompose.model.NoteModel

class DataSource {
    fun getNote() = listOf<NoteModel>(
        NoteModel(title = "wqwq", notes = "asdsasasasa"),
        NoteModel(title = "wqwq", notes = "asdsasasasa"),
        NoteModel(title = "wqwq", notes = "asdsasasasa"),
        NoteModel(title = "wqwq", notes = "asdsasasasa"),
        NoteModel(title = "wqwq", notes = "asdsasasasa"),
        NoteModel(title = "wqwq", notes = "asdsasasasa")
    )
}