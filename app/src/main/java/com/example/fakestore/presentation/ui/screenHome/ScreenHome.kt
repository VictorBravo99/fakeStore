package com.example.fakestore.presentation.ui.screenHome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.fakestore.R
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModelHome: ViewModelHome = hiltViewModel()
) {

    val category = viewModelHome.category
    val product = viewModelHome.product

    LaunchedEffect(Unit) {
        viewModelHome.startHome()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Account"
            )
            Text(
                text = "Fake Store",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Shopping Cart"
            )
        }

        DockedSearchBar(
            inputField = {
                SearchBarDefaults.InputField(
                    query = "",
                    onQueryChange = {},
                    onSearch = {},
                    expanded = false,
                    onExpandedChange = {},
                    placeholder = { Text(text = "Search for products") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                )
            },
            expanded = false,
            onExpandedChange = {},
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(16.dp),
            tonalElevation = SearchBarDefaults.TonalElevation,
            shadowElevation = SearchBarDefaults.ShadowElevation,
            content = { },
        )

        category?.onSuccess {
            LazyRow(modifier = Modifier.padding(bottom = 16.dp)) {
                items(it.size) { index ->
                    if (index == 0) Spacer(modifier = Modifier.width(16.dp))
                    FilterChip(
                        modifier = Modifier.padding(end = 8.dp),
                        selected = false,
                        onClick = { /*TODO*/ },
                        label = { Text(text = it[index].name) }
                    )
                    if (index == 9) Spacer(modifier = Modifier.width(8.dp))
                }
            }

        }


        product?.onSuccess {
            LazyRow {
                items(it.size) { index ->
                    if (index == 0) Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.width(240.dp)) {
                        AsyncImage(
                            model = it[index].images[0],
                            contentScale = ContentScale.Crop,
                            contentDescription = it[index].description,
                            modifier = Modifier
                                .height(130.dp)
                                .width(240.dp)
                                .padding(end = 8.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Text(
                            text = it[index].title,
                            modifier = Modifier.padding(horizontal = 4.dp),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    }
                    if (index == 9) Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }?.onFailure {
            Timber.d("paso dos")
        }


        Text(
            "Categories",
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 16.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge
        )
        category?.onSuccess {

            Column(modifier = Modifier.fillMaxWidth(0.9f)) {
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalArrangement = Arrangement.spacedBy(8.dp)

                ) {

                    Timber.e("debug en view SreenHome ${it.size}")

                    for (categoryItem in it) {
                        Column(
                            modifier = Modifier.fillMaxWidth(0.48f)
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
                            Text(text = categoryItem.name, modifier = Modifier.padding(top = 4.dp))
                        }

                    }

                }
            }

        }
    }
}

@Composable
fun AnimatedPreload(modifier: Modifier = Modifier, animationResource: Int, isPlaying : Boolean = true) {
    val preloadLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            animationResource
        )
    )

    LottieAnimation(
        composition = preloadLottieComposition,
        modifier = modifier,
        isPlaying = isPlaying,
        iterations = LottieConstants.IterateForever,

    )
}
