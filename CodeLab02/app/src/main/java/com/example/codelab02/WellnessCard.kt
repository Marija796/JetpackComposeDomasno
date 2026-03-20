package com.example.codelab02

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue

@Composable
fun WellnessCard(
    tip: WellnessTip,
    expanded: Boolean,
    onClick: () -> Unit
) {

    val color by animateColorAsState(
        if (expanded) MaterialTheme.colorScheme.primaryContainer
        else MaterialTheme.colorScheme.secondaryContainer
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
        ) {

            Text(
                text = tip.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            AnimatedVisibility(visible = expanded) {
                Text(tip.description)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = onClick) {
                Text(if (expanded) "Show Less" else "Show More")
            }
        }
    }
}