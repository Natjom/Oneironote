package com.example.oneironote.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text

@Composable
fun BottomNavigationBar(currentPage: MutableState<String>, colors: ColorScheme) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        containerColor = colors.primary
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationButton(label = "L1", onClick = { currentPage.value = "page1" })
            NavigationButton(label = "L2", onClick = { currentPage.value = "page2" })

            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(colors.primary, shape = RoundedCornerShape(32.dp))
                    .clickable { currentPage.value = "home" },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Home", color = Color.White, fontSize = 12.sp)
            }

            NavigationButton(label = "R2", onClick = { currentPage.value = "page3" })
            NavigationButton(label = "R1", onClick = { currentPage.value = "page4" })
        }
    }
}

@Composable
fun NavigationButton(label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(Color.Gray, shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(text = label, color = Color.White)
    }
}
