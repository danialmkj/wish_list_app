package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepository: WishRepository) : ViewModel() {

    //we want to keep data, get data and load our data here
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")


    fun wishTitleChange(newString: String) {
        wishTitleState = newString
    }

    fun wishDescriptionChange(newString: String) {
        wishDescriptionState = newString
    }

    //lateinit is alternative late keyword in Dart
    lateinit var getAllWishes: Flow<List<Wish>>


    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish) {
        //by using Dispacher.IO the system resources are use efficiently and don't bloc the main thread
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish)
        }
    }

    fun getWishById(id: Long): Flow<Wish> {
        return wishRepository.getWishById(id)
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch {
            wishRepository.updateWish(wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch {
            wishRepository.deleteWish(wish)
        }
    }

}