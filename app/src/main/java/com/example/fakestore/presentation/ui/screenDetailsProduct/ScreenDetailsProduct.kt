package com.example.fakestore.presentation.ui.screenDetailsProduct

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.fakestore.R
import com.example.fakestore.presentation.navigation.Screen

@Composable
fun ScreenDetailsProduct(
    modifier: Modifier = Modifier,
    id: Int,
    viewModel: ViewModelDetailsProduct = hiltViewModel(),
    navController: NavController = rememberNavController()
) {
    LaunchedEffect(Unit) {
        viewModel.startDetailsProduct(id)
    }

    val details = viewModel.details

    Scaffold(
        bottomBar={
            Column(modifier = Modifier.fillMaxWidth().background(Color.Transparent)) {
                Button(
                    {},
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.9f)
                ) {
                    Text("Add to Cart")
                }
            }
        }
    ) {
        Column(
            modifier = modifier.fillMaxSize().consumeWindowInsets(it),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                IconButton({
                    navController.popBackStack(
                        route = Screen.HomeScreen.route,
                        inclusive = false
                    )
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )

                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
            }
            details?.images?.let {
                if (it.size > 1) {
                    LazyRow {
                        items(it.size) { index ->
                            if (index == 0) Spacer(modifier = Modifier.width(16.dp))
                            AsyncImage(
                                model = it[index],
                                contentScale = ContentScale.Crop,
                                contentDescription = it[index],
                                modifier = Modifier
                                    .fillMaxHeight(0.3f)
                                    .padding(end = 8.dp)
                                    .clip(RoundedCornerShape(12.dp))

                            )
                        }

                    }
                } else Column(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = it[0],
                        contentScale = ContentScale.Fit,
                        contentDescription = it[0],
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxHeight(0.3f)
                            .padding(end = 8.dp)
                            .clip(RoundedCornerShape(12.dp))

                    )
                }

            }

            Text(
                text = details?.title ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "100+ sold",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Precio",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = details?.price.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Text(
                text = "Descripción",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = details?.description ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

        }

    }


}