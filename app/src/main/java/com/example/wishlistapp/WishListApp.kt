package com.example.wishlistapp

import android.app.Application

//using provider in onCreate method in Graph object to use from Application class
class WishListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}