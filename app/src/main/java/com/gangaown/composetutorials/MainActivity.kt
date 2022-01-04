package com.gangaown.composetutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp



class MainActivity : AppCompatActivity() {
    private lateinit var  viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = MainActivityViewModel()
        setContent{
            HelloWord()
        }

    }
    @Composable
    fun HelloWord(){
        Box(Modifier.fillMaxSize()) {

            Column(modifier = Modifier.padding(30.dp)) {
                Text(
                    text = "Hello World!",
                    modifier = Modifier.padding(bottom = 10.dp),
                    style = MaterialTheme.typography.h5
                )
                val textState1 = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    value = textState1.value,
                    onValueChange = {textState1.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Firstname") }
                )

                val textState2 = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    value = textState2.value,
                    onValueChange = {textState2.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Lastname") }
                )
                Spacer(modifier = Modifier.height(15.dp))

                Text("Full name is : " + textState1.value.text+" "+textState2.value.text)
            }


            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp),
                onClick = {
                    Toast.makeText(baseContext,"You clicked me!", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("+")
            }
        }

    }
}