package com.coderscastle.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coderscastle.textfield.ui.theme.TextfieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextfieldTheme {
                MyTextField()
            }
        }
    }
}


@Composable
fun MyTextField(){

    val focusManager = LocalFocusManager.current //for focus manager

    Box (
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit){
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }, contentAlignment = Alignment.Center){


        var state  by remember {
            mutableStateOf("")
        }

        Column {

            TextField(
                value = state,
                onValueChange = {state = it},
                label = { Text(text = "Enter Your Name")},
                placeholder = { Text(text = "Name")},
                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = Color.Black,
                    focusedTextColor = Color.Yellow,
                    unfocusedContainerColor = Color.Yellow,
                    unfocusedIndicatorColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    focusedContainerColor = Color.Green),
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Person") },
                shape = RoundedCornerShape(15.dp),
                isError = false,
                trailingIcon = { Icon(imageVector = Icons.Default.Info, contentDescription = "Person") },
                prefix =  { Text(text = "")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus()}),
                supportingText = {Text(text = "*Required")},

            )

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTextFieldPreview (){
    MyTextField()
}