package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepository

// object Graph is simple example of dependency injection in kotlin
//object graph declares a singleton named graph
//object keyword is used to declare a singleton
//A Singleton is a class of which only one instance will exist in the application which means that we can't create another graph object
//so this object grapph use as a service locator
object Graph {

    //we want to initialize DataBase
    // lateinit is a non-nullable property database
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