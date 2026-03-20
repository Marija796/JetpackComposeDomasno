package com.example.codelab01

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun WellnessList(tips: List<WellnessTip>) {
    LazyColumn {
        items(tips) { tip ->
            var expanded by rememberSaveable { mutableStateOf(false) }

            WellnessItem(
                tip = tip,
                expanded = expanded,
                onClick = { expanded = !expanded }
            )
        }
    }
}