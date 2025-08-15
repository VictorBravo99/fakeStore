package com.example.fakestore.presentation.common.sharedComponents.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fakestore.R
import com.example.fakestore.data.network.model.Category

@Composable
fun CardCategory(modifier: Modifier = Modifier, categoryItem: Category) {
    Column(
        modifier = Modifier.fillMaxWidth(0.48f),
    ) {
        AsyncImage(
            model = categoryItem.image,
            error = painterResource(R.drawable.file_error),
            contentScale = ContentScale.Crop,
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Text(
            text = categoryItem.name,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}