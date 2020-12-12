package com.netlsd.musefm.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.netlsd.musefm.ui.purple500
import com.netlsd.musefm.util.matchParent

@Composable
fun SettingsScreen() {
    Box(modifier = matchParent) {
        Surface(color = purple500, modifier = matchParent) {}
        Column(
            modifier = matchParent,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Settings",
                color = Color.White,
                fontWeight = FontWeight.W500,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                style = TextStyle()
            )
        }
    }
}