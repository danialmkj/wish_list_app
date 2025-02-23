package com.example.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddEditDetail(
    id: Long, viewModel: WishViewModel, navController: NavController
) {
    Scaffold(topBar = {
        AppBarView(
            title = if (id != 0L) stringResource(R.string.update_wish)
            else stringResource(R.string.add_wish),
            onBackNavClicked = {
                navController.navigateUp()
            }
        )
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            //TODO Title TextField
            WishTextField(label = "Title", value = viewModel.wishTitleState, onValueChange = { it ->
                viewModel.wishTitleChange(it)
            })

            Spacer(modifier = Modifier.height(8.dp))

            //TODO Description TextField
            WishTextField(label = "Description",
                value = viewModel.wishDescriptionState,
                onValueChange = { it -> viewModel.wishDescriptionChange(it) })


            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                if (viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()) {
                    //TODO Update Wish
                } else {
                    //TODO Add Wish
                }
            }) {
                Text(text = if (id != 0L) stringResource(R.string.update_wish) else stringResource(R.string.add_wish))
            }

        }
    }
}


@Composable
fun WishTextField(
    label: String, value: String, onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = Color.Black) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            //using predefined colors
            textColor = Color.Black,

            //using our own colors
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black
        )
    )

}

@Preview
@Composable
fun PreviewWishTextFields() {
    WishTextField(label = "Title", value = "SubTitle", onValueChange = {})
}