package com.example.jetpackcomposedictionary.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedictionary.*

@Composable
fun TaggedSearchScreen() {

    var dictQuery by remember { mutableStateOf("") }
    var dictResult by remember { mutableStateOf("") }

    var tagQuery by remember { mutableStateOf("") }

    var tags by remember {
        mutableStateOf(
            listOf(
                "AndroidFP", "Deitel", "Google",
                "iPhoneFP", "JavaFP", "JavaHTP"
            )
        )
    }

    val context = LocalContext.current
    val dictionary = remember { loadDictionary(context) }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {

            // DICTIONARY CARD
            Card(modifier = Modifier.fillMaxWidth()) {

                Column(modifier = Modifier.padding(10.dp)) {

                    Text(
                        text = "Dictionary / Речник",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = dictQuery,
                        onValueChange = { dictQuery = it },
                        label = { Text("Enter word") },
                        leadingIcon = {
                            Icon(Icons.Default.Search, null)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            dictResult =
                                searchInDictionary(dictionary, dictQuery)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Search")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    if (dictResult.isNotEmpty()) {
                        Text(
                            text = "$dictQuery = $dictResult",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // TAG INPUT
            OutlinedTextField(
                value = tagQuery,
                onValueChange = { tagQuery = it },
                label = { Text("Tag your query") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    if (tagQuery.isNotBlank()) {
                        tags = tags + tagQuery
                        tagQuery = ""
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Save")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tagged Searches",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(tags) { tag ->
                    TagItem(tag)
                }
            }
        }

        FloatingActionButton(
            onClick = { tags = emptyList() },
            containerColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            Icon(Icons.Default.Delete, contentDescription = null)
        }
    }
}