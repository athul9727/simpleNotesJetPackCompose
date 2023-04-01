package com.example.simplenotesjetpackcompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.simplenotesjetpackcompose.model.NoteModelEntity
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteInputField(
    modifier: Modifier = Modifier,
    text:String,
    label:String,
    maxLine:Int = 1,
    onTextChange:(String) -> Unit,
    onImeAction:() -> Unit = {}

){
    val keyBoardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = maxLine ,
        label = { Text(text = label)},
       keyboardActions = KeyboardActions(onDone = {
           onImeAction()
           keyBoardController?.hide()
       }),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
    )

}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String = "save",
    onClick: () -> Unit,
    enabled: Boolean = true
){

    Button(onClick = onClick, shape = CircleShape, enabled = enabled, modifier = modifier) {
           Text(text = text)
    }

}

@Composable
fun NoteRow(
    modifier:Modifier =  Modifier.padding(6.dp),
    note:NoteModelEntity,
    onNoteClicked:(NoteModelEntity) -> Unit
){
    
    Surface(modifier= modifier
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
        .fillMaxWidth(), color = Color(0xFFDFE6EB), elevation = 6.dp) {

         Column(
             modifier
                 .clickable {

                     onNoteClicked(note)

                 }
                 .padding(horizontal = 14.dp, vertical = 6.dp),
                   horizontalAlignment = Alignment.Start) {
             
             Text(text = note.title, style = MaterialTheme.typography.subtitle2)
             Text(text = note.notes, style = MaterialTheme.typography.subtitle1)
             Text(text = note.entryTime.format(DateTimeFormatter.ofPattern("EEE, d MMM")), style = MaterialTheme.typography.subtitle1)


         }
        
    }


}