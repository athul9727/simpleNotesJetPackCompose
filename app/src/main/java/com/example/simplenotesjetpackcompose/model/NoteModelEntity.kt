package com.example.simplenotesjetpackcompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "NoteTable")
data class NoteModelEntity(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "Title")
    val title:String,
    @ColumnInfo(name = "Note")
    val notes:String,
    @ColumnInfo(name = "Date")
   // val entryTime:LocalDateTime = LocalDateTime.now()
    val entryTime:Date = Date.from(Instant.now())
) {
}