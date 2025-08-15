package com.example.fakestore.presentation.common.sharedComponents.card

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.fakestore.data.db.entity.ProductEntity
import com.example.fakestore.presentation.navigation.HOME_TO_NAV_DETAILS_PRODUCT
import com.example.fakestore.presentation.navigation.Screen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.CardProduct(
    modifier: Modifier = Modifier,
    product : ProductEntity,
    navController: NavHostController,
    animationVisibilityScope: AnimatedVisibilityScope,
) {
    Column(
        modifier = Modifier
            .width(240.dp)
            .sharedElement(
                sharedContentState = rememberSharedContentState(
                    HOME_TO_NAV_DETAILS_PRODUCT + product.id.toString()
                ),
                animatedVisibilityScope = animationVisibilityScope,
                boundsTransform = { _, _ ->
                    tween(durationMillis = 500)
                }

            )
            .clickable {
                navController.navigate(
                    Screen.DetailsProductScreen.createRoute(
                        product.id
                    )
                )

            }
    ) {
        AsyncImage(
            model = product.images[0],
            contentScale = ContentScale.Crop,
            contentDescription = product.description,
            modifier = Modifier
                .height(130.dp)
                .width(240.dp)
                .padding(end = 8.dp)
                .clip(RoundedCornerShape(12.dp))

        )
        Text(
            text = product.title,
            modifier = Modifier.padding(horizontal = 4.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }


}