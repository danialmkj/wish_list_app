package com.example.wishlistapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.data.DummyWish
import com.example.wishlistapp.data.Wish

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
) {
    Scaffold(
        topBar = { AppBarView(title = "WishList ", onBackNavClicked = {}) },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(20.dp),
                contentColor = Color.White,
                containerColor = Color.Black,
                onClick = {
                    //TODO Add Navigation to Add Screen
                    navController.navigate(Screen.AddScreen.routeName)
                },
            ) { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
        }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(DummyWish.wishList) { item: Wish ->
                WishItem(wish = item, onClick = {})
            }
        }
    }
}


@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clickable { onClick() }, elevation = 10.dp, backgroundColor = Color.White
    ) {
        Column(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()) {
            Text(wish.title, fontWeight = FontWeight.ExtraBold)
            Text(wish.description)
        }
    }
}