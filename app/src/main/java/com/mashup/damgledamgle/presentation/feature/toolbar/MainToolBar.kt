package com.mashup.damgledamgle.presentation.feature.toolbar

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MainToolBar(title : String) {
    TopAppBar(
        title = { Text(text = title)},
        backgroundColor = Color.Black
    )
}
