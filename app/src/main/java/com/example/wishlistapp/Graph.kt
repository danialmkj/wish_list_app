package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepository

object Graph {

    //we want to initialize DataBase

    lateinit var database: WishDatabase

    // Initialize wishRepository when first needed.
    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        //build our database
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}