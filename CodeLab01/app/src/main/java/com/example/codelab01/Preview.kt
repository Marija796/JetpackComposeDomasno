package com.example.codelab01

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.codelab01.ui.theme.CodeLab01Theme

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    CodeLab01Theme {
        MyApp()
    }
}