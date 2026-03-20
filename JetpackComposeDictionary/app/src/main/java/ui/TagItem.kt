package com.example.jetpackcomposedictionary.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TagItem(tag: String) {

    var expanded by remember { mutableStateOf(false) }

    // Card за секој tag
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFCE4EC)
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = tag,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF880E4F)
                )
                Text(
                    text = "Tap",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF880E4F)
                )
            }

            AnimatedVisibility(visible = expanded) {
                Text(
                    text = "Details for $tag",
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF880E4F)
                )
            }
        }
    }
}