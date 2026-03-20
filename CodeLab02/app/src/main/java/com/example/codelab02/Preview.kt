package com.example.codelab02

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.codelab02.ui.theme.CodeLab02Theme

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    CodeLab02Theme {
        WellnessApp()
    }
}