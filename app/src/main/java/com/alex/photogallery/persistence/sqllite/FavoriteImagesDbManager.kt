package com.alex.photogallery.persistence.sqllite

import android.content.Context
import android.media.Image
import android.util.Log
import com.alex.photogallery.persistence.entities.FavoriteImageData
import com.alex.photogallery.persistence.entities.ImageData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object FavoriteImagesDbManager {

    fun saveFavoriteImage(context: Context, favoriteImage:FavoriteImageData, listener:()->Unit){

        GlobalScope.launch(Dispatchers.IO){
            var dbManager = SqlLiteDatabaseManager.getDatabase(context).getFavoriteImageDAO()

            var favoriteImageInDb=dbManager.getFavoriteImage(favoriteImage.imageId)

            Log.d("TAG", "Empieza la modificación a la base de datos")

            if (favoriteImageInDb != null){
                Log.d("TAG", "Borrar")
                dbManager.deleteFavoriteImage(favoriteImage)

            }else{
                Log.d("TAG", "Guardar")
                dbManager.insertFavoriteImage(favoriteImage)
            }

            withContext(Dispatchers.Main){
                Log.d("TAG", "La imagen ha sido modificada")
                listener()
            }

        }
    }
}