package com.example.simplenotesjetpackcompose.model

import java.time.LocalDateTime
import java.util.*

data class NoteModel(val id: UUID = UUID.randomUUID(), val title:String, val notes:String,val entryTime:LocalDateTime = LocalDateTime.now()) {
}