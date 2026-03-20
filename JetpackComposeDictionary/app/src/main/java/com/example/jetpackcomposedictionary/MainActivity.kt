
package com.example.jetpackcomposedictionary
import com.example.jetpackcomposedictionary.ui.TaggedSearchScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val pinkTheme = lightColorScheme(
                primary = androidx.compose.ui.graphics.Color(0xFFE91E63),
                secondary = androidx.compose.ui.graphics.Color(0xFFF8BBD0)
            )

            MaterialTheme(colorScheme = pinkTheme) {
                TaggedSearchScreen()
            }
        }
    }
}