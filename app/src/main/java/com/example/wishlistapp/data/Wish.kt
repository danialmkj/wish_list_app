package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//create Wish Table via Room DB
@Entity(tableName = "wish_table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo("wish_title")
    val title: String = "",
    @ColumnInfo("wish_desc")
    val description: String = ""
)


//create fake data of Wish List

object DummyWish {
    val wishList = listOf(
        Wish(id = 1, title = "Apple", description = "Mac , Apple Watch , iMac"),
        Wish(id = 2, title = "Samsung", description = "Mobile , Laptop , TV"),
        Wish(id = 3, title = "Huawei", description = "Phone, Laptop, TV"),
        Wish(id = 4, title = "Xiaomi", description = "new Phone, Laptop, TV"),
        Wish(id = 5, title = "Google", description = "Phone, Services , TV"),
    )
}
