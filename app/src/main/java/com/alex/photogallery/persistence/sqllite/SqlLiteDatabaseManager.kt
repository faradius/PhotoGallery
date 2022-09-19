package com.alex.photogallery.persistence.sqllite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alex.photogallery.persistence.dao.FavoriteImageDAO
import com.alex.photogallery.persistence.entities.FavoriteImageData

@Database(entities = [FavoriteImageData::class], version = 1, exportSchema = false)
abstract class SqlLiteDatabaseManager:RoomDatabase() {

    abstract fun getFavoriteImageDAO():FavoriteImageDAO

    companion object{

        @Volatile
        private var instance:SqlLiteDatabaseManager?=null

        fun getDatabase(context: Context):SqlLiteDatabaseManager=
            instance?: synchronized(this){
                instance?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,SqlLiteDatabaseManager::class.java, "Gallery")
                .fallbackToDestructiveMigration()
                .build()

    }
}