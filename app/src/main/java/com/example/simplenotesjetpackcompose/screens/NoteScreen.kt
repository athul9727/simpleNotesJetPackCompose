package com.example.simplenotesjetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplenotesjetpackcompose.R
import com.example.simplenotesjetpackcompose.components.NoteInputField

@Composable
fun NoteScreen(){

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

            NoteInputField(text = "", label = "Title", onTextChange ={

            } )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen()
}