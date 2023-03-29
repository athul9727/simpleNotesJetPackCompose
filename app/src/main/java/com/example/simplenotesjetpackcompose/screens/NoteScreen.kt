package com.example.simplenotesjetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplenotesjetpackcompose.R
import com.example.simplenotesjetpackcompose.components.NoteButton
import com.example.simplenotesjetpackcompose.components.NoteInputField
import com.example.simplenotesjetpackcompose.data.DataSource
import com.example.simplenotesjetpackcompose.model.NoteModel

@Composable
fun NoteScreen(
    notes:List<NoteModel>,
    onAddNote : (NoteModel) -> Unit,
    onRemoveNote : (NoteModel) -> Unit,
){

    var titleState by remember { mutableStateOf("") }
    var notesState by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(6.dp)) {

        TopAppBar(
            backgroundColor = Color(0xFFDADFE3),
            title = {
                Text(text = stringResource(id = R.string.app_name))
                    },
            actions = {
                Icon(Icons.Rounded.Notifications,
                contentDescription = "notification")
            }
        )

        Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

            NoteInputField(text = titleState, label = "Title", maxLine = 2, onTextChange = {
                if(it.all { char-> char.isLetter() or char.isWhitespace() }){ titleState = it }
            }, modifier = Modifier.padding(all = 6.dp) )

            NoteInputField(text = notesState, label = "Notes", maxLine = 20, onTextChange = {
                if(it.all { char-> char.isLetter() or char.isWhitespace() }){ notesState = it }
            },  modifier = Modifier.padding(all = 6.dp) )
            
            NoteButton(onClick = {

                if(titleState.isNotEmpty() and notes.isNotEmpty()){
                    titleState = ""
                    notesState = ""
                }

            }, text = "save",  modifier = Modifier.padding(all = 6.dp))


        }


        Divider(  modifier = Modifier.padding(all = 6.dp))

        LazyColumn {
            items(notes){
                Text(text = it.title)
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen(
        notes = DataSource().getNote(),

      onAddNote = {

    }, onRemoveNote = {

    })
}