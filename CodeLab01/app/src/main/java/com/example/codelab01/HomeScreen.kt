package com.example.codelab01

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    val tips = listOf(
        WellnessTip("Drink Water 💧", "Stay hydrated throughout the day."),
        WellnessTip("Morning Walk 🚶‍♀️", "Start your day with fresh air."),
        WellnessTip("Healthy Food 🥗", "Eat balanced meals."),
        WellnessTip("Meditation 🧘‍♀️", "Relax your mind daily."),
        WellnessTip("Good Sleep 😴", "Sleep at least 7-8 hours.")
    )

    Column {
        TopBar()
        WellnessList(tips)
    }
}