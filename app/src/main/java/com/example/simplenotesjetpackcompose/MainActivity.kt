package com.example.simplenotesjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.simplenotesjetpackcompose.screens.NoteScreen
import com.example.simplenotesjetpackcompose.screens.NoteViewModel
import com.example.simplenotesjetpackcompose.ui.theme.SimpleNotesJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val noteViewModel:NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNotesJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}


@Composable
fun NotesApp(noteViewModel: NoteViewModel){

    val noteList = noteViewModel.noteList.collectAsState().value

    NoteScreen(
        notes = noteList,

        onAddNote = {
            noteViewModel.addNote(it)

        }, onRemoveNote = {
            noteViewModel.removeNote(it)
        })
}


