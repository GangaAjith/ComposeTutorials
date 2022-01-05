package com.gangaown.composetutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainViewModel()
        setContent{
            HelloWord()
        }

    }
    @Composable
    fun HelloWord() {
        Box(Modifier.fillMaxSize()) {

            Column(modifier = Modifier.padding(30.dp)) {
                Text(
                    text = "Hello World!",
                    modifier = Modifier.padding(bottom = 10.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                val firstNameState = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    value = firstNameState.value,
                    onValueChange = { firstNameState.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Firstname") }
                )

                val lastNameState = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    value = lastNameState.value,
                    onValueChange = { lastNameState.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Lastname") }
                )
                Spacer(modifier = Modifier.height(15.dp))

                Text("Full name is : " + firstNameState.value.text + " " + lastNameState.value.text)

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Hobbies",
                    modifier = Modifier.padding(bottom = 10.dp),
                    style = MaterialTheme.typography.h5,
                )

                val hobbiesList = remember  {viewModel.hobbies}
                LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        itemsIndexed(hobbiesList) { i, item ->
                            Text(
                                text = "${i + 1}.${item}",
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                            Divider()
                        }
                    }
            }

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp),
                onClick = {
                    viewModel.addHobbies()
                    Toast.makeText(baseContext,"Hobby added successfully!", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("+")
            }
        }

    }
}