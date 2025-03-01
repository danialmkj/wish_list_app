package com.example.wishlistapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.data.DummyWish
import com.example.wishlistapp.data.Wish

@OptIn(ExperimentalMaterialApi::class)
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
                    //TODO Add Navigation to Add Screen and we add id=0L to app wont crash
                    navController.navigate(Screen.AddScreen.routeName + "/0L")
                },
            ) { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
        }) {
        //get all the wishes
        val wishList = viewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            //we use key which going to use wish id
            items(wishList.value , key = {wish -> wish.id}) { item: Wish ->

                val dismissState = rememberDismissState(confirmStateChange = { dismissValue ->
                    if (dismissValue == DismissValue.DismissedToEnd || dismissValue == DismissValue.DismissedToStart) {
                        viewModel.deleteWish(wish = item)
                    }
                    true
                })

                SwipeToDismiss(
                    state = dismissState,
                    background = {},
                    directions = setOf(
                        DismissDirection.EndToStart,
                        DismissDirection.StartToEnd
                    ),
                    dismissThresholds = { FractionalThreshold(fraction = 0.25f) },
                    //which Item we want to dismiss it
                    dismissContent = {
                        WishItem(wish = item, onClick = {
                            //TODO fetch wish item base on id
                            val id = item.id
                            navController.navigate(Screen.AddScreen.routeName + "/$id")
                        })
                    }
                )
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
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(wish.title, fontWeight = FontWeight.ExtraBold)
            Text(wish.description)
        }
    }
}