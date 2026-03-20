package com.example.codelab01

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp

@Composable
fun TopBar() {
    Surface(
        tonalElevation = 6.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "🌿 Wellness Tips",
            modifier = Modifier.padding(20.dp),
            style = MaterialTheme.typography.headlineMedium
        )
    }
}