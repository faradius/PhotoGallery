package com.alex.photogallery.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.alex.photogallery.persistence.entities.FavoriteImageData


@Dao
interface FavoriteImageDAO {

    @Insert
    fun insertFavoriteImage(favoriteImageData: FavoriteImageData)

    @Query("SELECT * FROM favorite_image")
    fun getFavoriteImages():List<FavoriteImageData>?

    @Query("SELECT * FROM favorite_image WHERE imageId=:imageId")
    fun getFavoriteImage(imageId:Int):FavoriteImageData?

    @Delete
    fun deleteFavoriteImage(favoriteImageData: FavoriteImageData)

    @Update
    fun updateFavoriteImage(favoriteImageData: FavoriteImageData)


}