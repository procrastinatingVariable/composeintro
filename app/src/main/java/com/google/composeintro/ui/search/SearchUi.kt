package com.google.composeintro.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.composeintro.model.Dessert
import com.google.composeintro.model.desserts
import com.google.composeintro.ui.home.PickDessertItem

@Composable
fun SearchUi(desserts: List<Dessert>) {
    //✏️✏️✏️ TODO add state for search query
    //✏️✏️✏️ TODO add state fo search result (show all desserts initially)
    val searchQuery = remember { mutableStateOf("") }
    val searchResult = remember { mutableStateOf(desserts) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            //✏️✏️✏️ TODO add OutlinedTextField for the search input
            OutlinedTextField(
                value = searchQuery.value,
                onValueChange = { newValue -> searchQuery.value = newValue },
                modifier = Modifier.weight(1f)
            )

            //✏️✏️✏️ TODO to the filtering when the icon is clicked
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "search button",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        searchResult.value = desserts.filter { dessert ->
                            dessert.name.contains(searchQuery.value)
                        }
                    }
            )
        }

        Spacer(Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            //✏️✏️✏️ TODO show result of the query
            items(searchResult.value) { dessert ->
                PickDessertItem(dessert)
            }
        }
    }
}

@Preview
@Composable
fun SearchUiPreview() {
    SearchUi(
        desserts
    )
}