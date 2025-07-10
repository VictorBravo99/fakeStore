package com.example.fakestore.presentation.ui.screenLogin.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ModalLogin(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Card(modifier = modifier, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)) {
        content()
    }
}