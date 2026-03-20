package com.example.codelab02

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessScreen() {

    val tips = listOf(
        WellnessTip("Morning Yoga 🧘", "Start your day with stretching."),
        WellnessTip("Drink Water 💧", "Stay hydrated."),
        WellnessTip("Healthy Food 🥗", "Eat nutritious meals."),
        WellnessTip("Meditation 🧠", "Relax your mind."),
        WellnessTip("Walk 🚶‍♀️", "Stay active daily.")
    )

    Column {
        TopBar()
        LazyColumn(
            contentPadding = PaddingValues(8.dp)
        ) {
            items(tips) { tip ->
                var expanded by rememberSaveable { mutableStateOf(false) }

                WellnessCard(
                    tip = tip,
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
        }
    }
}