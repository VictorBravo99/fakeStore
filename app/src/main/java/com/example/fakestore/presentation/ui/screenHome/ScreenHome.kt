package com.example.fakestore.presentation.ui.screenHome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome(modifier: Modifier = Modifier, navController: NavHostController) {
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

        LazyRow(modifier = Modifier.padding(bottom = 16.dp)) {
            // Es importante usar el 'items' correcto para LazyRow
            items(10) { index -> // Cambiado de 'it' a 'index' para claridad
                if (index == 0) Spacer(modifier = Modifier.width(16.dp))
                FilterChip(
                    modifier = Modifier.padding(end = 8.dp),
                    selected = false,
                    onClick = { /*TODO*/ },
                    label = { Text(text = "Category $index") }
                )
                if (index == 9) Spacer(modifier = Modifier.width(8.dp))
            }
        }

        LazyRow {
            items(10) { index ->
                if (index == 0) Spacer(modifier = Modifier.width(16.dp))
                Column {
                    AsyncImage(
                        model = "https://picsum.photos/400/200",
                        contentScale = ContentScale.Crop,
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .height(130.dp)
                            .width(240.dp)
                            .padding(end = 8.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Text(text = "producto example $index")
                }
                if (index == 9) Spacer(modifier = Modifier.width(8.dp))
            }
        }

        Text(
            "Categories",
            modifier = Modifier
                .fillMaxWidth(0.9f) // Para alinear con el resto del contenido
                .padding(top = 16.dp, bottom = 8.dp), // Ajusta el padding
            style = MaterialTheme.typography.titleLarge
        )
        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            FlowRow {

                for (x in 1..10) {
                    Column(
                        modifier = Modifier.fillMaxWidth(0.5f)
                    ) {
                        AsyncImage(
                            model = "https://picsum.photos/400/400",
                            contentScale = ContentScale.Crop,
                            contentDescription = "Product Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Text(text = "Category example $x", modifier = Modifier.padding(top = 4.dp))
                    }

                }

            }
        }
    }
}
