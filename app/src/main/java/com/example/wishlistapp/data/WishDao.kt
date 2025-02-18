package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

//abstract class is a classes that has methods that don't need an implementation
//that means we set-up methods that don't have a body
//we use suspend because that methods happen in background and also because we are using Flow in other methods which are type of coroutine so we don't use suspend keyword there
//Use suspend when you have functions that might take some time to complete (like network calls or database operations) and you don't want to block the thread while waiting. It's a fundamental part of Kotlin's coroutines, which make asynchronous programming much easier and more readable.
@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    //Load All Data from Wish Table
    @Query("Select * from 'wish_table' ")
    abstract fun getAllWish(): Flow<List<Wish>>
    //Flow is a kotlin coroutine library which provide simple and efficient way to
    // handle asynchronous data stream in a reactive way which Fetch and emit updates during data manipulation


    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Query("Select * from 'wish_table' where id = :id")
    abstract fun getWishById(id: Long): Flow<Wish>

}